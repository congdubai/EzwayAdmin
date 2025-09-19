package com.infoplus.ezway.EzwayAdmin.dto;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class PagingDTO {
    @Positive
    private Integer pageSize;
    @Positive
    private Integer pageIndex;
    private long total;
    private boolean countTotal;
}
