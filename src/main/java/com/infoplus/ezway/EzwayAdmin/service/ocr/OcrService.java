package com.infoplus.ezway.EzwayAdmin.service.ocr;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse;
import com.infoplus.ezway.EzwayAdmin.mapper.OcrDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcrService {
    @Autowired
    private OcrDataMapper ocrDataMapper;

    public OcrDetailResponse doGetOcrDetail(String transId){
        CommonDTO detail = ocrDataMapper.findByTransId(transId);
        OcrDetailResponse response = new OcrDetailResponse();
        response.setData(detail);
        return response;
    }
}
