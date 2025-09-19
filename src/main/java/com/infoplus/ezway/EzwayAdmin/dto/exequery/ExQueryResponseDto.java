package com.infoplus.ezway.EzwayAdmin.dto.exequery;


import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExQueryResponseDto extends BaseResponseDto {
    private PagingDTO paging;
    private ExQueryResponseData data;

    @Data
    public static class ExQueryResponseData {
        private List<String> column;
        private List<Map<String, Object>> resultSet;
    }
}
