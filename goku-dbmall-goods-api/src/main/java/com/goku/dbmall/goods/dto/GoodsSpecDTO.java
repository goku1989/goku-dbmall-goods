package com.goku.dbmall.goods.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsSpecDTO {
    private String gkcode;

    private String goodsGkcode;

    private String name;

    private Long stock;

    private BigDecimal discounts;

    private BigDecimal priceDiscount;

    private BigDecimal priceNormal;
}
