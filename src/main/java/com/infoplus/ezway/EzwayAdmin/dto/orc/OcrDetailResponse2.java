package com.infoplus.ezway.EzwayAdmin.dto.orc;

import com.infoplus.ezway.EzwayAdmin.dto.BaseResponseDto;
import com.infoplus.ezway.EzwayAdmin.dto.CommonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OcrDetailResponse2 extends BaseResponseDto {
    private CommonDTO data;
    private OcrDataDto data2;
}
