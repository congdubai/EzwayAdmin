package com.infoplus.ezway.EzwayAdmin.dto.exequery;

import com.infoplus.ezway.EzwayAdmin.dto.PagingDTO;
import lombok.Data;

@Data
public class ExQueryRequestDto {
    private PagingDTO paging;
    private ExQueryRequestData data = new ExQueryRequestData();

    @Data
    public static class ExQueryRequestData {
        private String query;
    }
}
