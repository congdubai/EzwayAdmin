package com.infoplus.ezway.EzwayAdmin.service.faceMatch;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.FaceMatch.FaceMatchDetailResponse;
import com.infoplus.ezway.EzwayAdmin.mapper.FaceMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceMatchService {
    @Autowired
    private FaceMatchMapper faceMatchMapper;

    public FaceMatchDetailResponse doGetFaceMatchDetail(String transId){
        CommonDTO detail = faceMatchMapper.findByTransId(transId);
        FaceMatchDetailResponse response = new FaceMatchDetailResponse();
        response.setData(detail);
        return response;
    }
}
