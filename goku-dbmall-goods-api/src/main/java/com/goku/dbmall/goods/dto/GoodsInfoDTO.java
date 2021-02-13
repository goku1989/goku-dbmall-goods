package com.goku.dbmall.goods.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsInfoDTO {
    private String gkcode;

    private String goodsCode;

    private String goodsName;

    private String catGkcode;

    private Long sellCounts;

    private Byte onOffStatus;

    private String content;
}
