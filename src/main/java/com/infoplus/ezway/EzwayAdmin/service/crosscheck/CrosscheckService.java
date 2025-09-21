package com.infoplus.ezway.EzwayAdmin.service.crosscheck;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.crosscheck.CrosscheckDetailResponse;
import com.infoplus.ezway.EzwayAdmin.mapper.CrossCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrosscheckService {
    @Autowired
    private CrossCheckMapper crossCheckMapper;

    public CrosscheckDetailResponse doGetCrosscheckDetail(String transId){
        CommonDTO detail = crossCheckMapper.findByTransId(transId);
        CrosscheckDetailResponse response = new CrosscheckDetailResponse();
        response.setData(detail);
        return response;
    }
}
