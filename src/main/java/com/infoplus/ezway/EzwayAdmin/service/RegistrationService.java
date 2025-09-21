package com.infoplus.ezway.EzwayAdmin.service;

import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationRequest;
import com.infoplus.ezway.EzwayAdmin.dto.registration.RegistrationResponse;
import com.infoplus.ezway.EzwayAdmin.entity.RegistrationDataEntity;
import com.infoplus.ezway.EzwayAdmin.mapper.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationMapper registrationMapper;

    @Autowired
    private TaskExecutor businessExecutor;

    public RegistrationResponse doGetListRegistration(RegistrationRequest request)throws ExecutionException, InterruptedException{
        CompletableFuture<Long> ftCountAll = null;
        PagingDTO paging = request.getPaging();
        int startRow = (paging.getPageIndex() - 1) * paging.getPageSize();
        int endRow = paging.getPageIndex() * paging.getPageSize();
        if (paging.isCountTotal()) {
            ftCountAll = CompletableFuture.supplyAsync(() -> registrationMapper.countAllRegistration(request), businessExecutor);
        }
        List<RegistrationDataEntity> crosschecks = registrationMapper.selectRegistrationData(request, startRow, endRow);
        RegistrationResponse responseBody = new RegistrationResponse();
        if (ftCountAll != null) {
            paging.setTotal(ftCountAll.get());
        }
        responseBody.setData(crosschecks);
        responseBody.setPaging(paging);
        return responseBody;
    }
}
