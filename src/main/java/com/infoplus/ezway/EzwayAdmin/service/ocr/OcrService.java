package com.infoplus.ezway.EzwayAdmin.service.ocr;

import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse;
import com.infoplus.ezway.EzwayAdmin.dto.orc.OcrDetailResponse2;
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
    public OcrDetailResponse2 doGetOcrDetail2(String transId){
        CommonDTO detail = ocrDataMapper.findByTransId(transId);
        detail.setKind("ID_OCR");
        OcrDetailResponse2 response = ocrDataMapper.findByTransId2(transId);
        response.setData2(detail);
        return response;
    }
}
