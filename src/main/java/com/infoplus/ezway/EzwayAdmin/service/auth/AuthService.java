package com.infoplus.ezway.EzwayAdmin.service.auth;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthDetailResponse;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthRequest;
import com.infoplus.ezway.EzwayAdmin.dto.auth.AuthResponse;
import com.infoplus.ezway.EzwayAdmin.entity.authen.AuthenticationDataEntity;
import com.infoplus.ezway.EzwayAdmin.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AuthService {
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private TaskExecutor businessExecutor;

    public AuthResponse doGetListAuthentication(AuthRequest request)throws ExecutionException, InterruptedException{
        CompletableFuture<Long> ftCountAll = null;
        PagingDTO paging = request.getPaging();
        int startRow = (paging.getPageIndex() - 1) * paging.getPageSize();
        int endRow = paging.getPageIndex() * paging.getPageSize();
        if (paging.isCountTotal()) {
            ftCountAll = CompletableFuture.supplyAsync(() -> authMapper.countAllAuthentication(request), businessExecutor);
        }
        List<AuthenticationDataEntity> auths = authMapper.selectAuthenticationData(request, startRow, endRow);
        AuthResponse responseBody = new AuthResponse();
        if (ftCountAll != null) {
            paging.setTotal(ftCountAll.get());
        }
        responseBody.setData(auths);
        responseBody.setPaging(paging);
        return responseBody;
    }

    public AuthDetailResponse doGetAuthDetail(String transId){
        CommonDTO detail = authMapper.findByTransId(transId);
        AuthDetailResponse response = new AuthDetailResponse();
        response.setData(detail);
        return response;
    }
}
