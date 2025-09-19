package com.infoplus.ezway.EzwayAdmin.exequery;


import com.infoplus.ezway.EzwayAdmin.common.ErrGroupCode;
import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import com.infoplus.ezway.EzwayAdmin.dto.exequery.ExQueryRequestDto;
import com.infoplus.ezway.EzwayAdmin.dto.exequery.ExQueryResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ExeQueryService {
    private static final String[] SUPER_FORBIDDEN_KEYWORDS = {
            "DROP", "TRUNCATE", "ALTER"
    };

    private static final String[] FORBIDDEN_KEYWORDS = {
            "INSERT", "UPDATE", "DELETE", "MERGE", "EXEC", "CALL"
    };

    @Qualifier("ekycGwJdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public ExQueryResponseDto doExeQuery(ExQueryRequestDto requestDto) {
        PagingDTO paging = requestDto.getPaging();
        ExQueryResponseDto responseDto = new ExQueryResponseDto();
        responseDto.setPaging(paging);

        String query = requestDto.getData().getQuery();
        if (StringUtils.isBlank(query)) {
            responseDto.setResultCode(ErrGroupCode.E_FAIL.getGroupCode());
            responseDto.setResultDesc("SQL query is empty");
            return responseDto;
        }
        String normalizedQuery = query.trim().replaceAll("[\\n\\r]+", StringUtils.SPACE);
        if (!this.validateQuery(normalizedQuery)) {
            log.info("Illegal query: {}", query);
            responseDto.setResultCode(ErrGroupCode.E_FAIL.getGroupCode());
            responseDto.setResultDesc("SQL query is invalid, wrong syntax, contain forbidden keywords or DDL");
            return responseDto;
        }


        long total = 0;
        if (requestDto.getPaging().isCountTotal()) {
            String countSql = new StringBuilder().append("SELECT COUNT(*) FROM ( ")
                    .append(StringUtils.removeEnd(normalizedQuery, ";"))
                    .append(" )")
                    .toString();
            total = jdbcTemplate.queryForObject(countSql, Long.class);
        }
        log.info("total: {}", total);

        int endRow = paging.getPageIndex() * paging.getPageSize();
        int startRow = (paging.getPageIndex() - 1) * paging.getPageSize();
        paging.setTotal(total);
        jdbcTemplate.queryForList(query);
        String selectQuery = new StringBuilder()
                .append("SELECT * FROM (SELECT ROWNUM AS RN, ALL_DATA.* FROM ( ")
                .append(StringUtils.removeEnd(normalizedQuery, ";"))
                .append(" ) ALL_DATA ")
                .append(" WHERE ROWNUM <= ").append(endRow).append(") ")
                .append(" WHERE RN > ").append(startRow)
                .toString();
        List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);
        responseDto.setData(new ExQueryResponseDto.ExQueryResponseData());
        if (CollectionUtils.isNotEmpty(resultSet)) {
            List<String> column = new ArrayList<>(resultSet.get(0).keySet());
            responseDto.getData().setColumn(column);
        }
        responseDto.getData().setResultSet(resultSet);
        return responseDto;
    }

    private boolean validateQuery(String normalizedQuery) {
        if (!StringUtils.startsWithIgnoreCase(normalizedQuery, "SELECT")) {
            return false;
        }
        for (String superFobKw : SUPER_FORBIDDEN_KEYWORDS) {
            if (StringUtils.containsIgnoreCase(normalizedQuery, superFobKw)) {
                return false;
            }
        }
        for (String fobKw : FORBIDDEN_KEYWORDS) {
            if (StringUtils.containsIgnoreCase(normalizedQuery, fobKw.concat(StringUtils.SPACE))) {
                return false;
            }
        }
        return true;
    }
}
