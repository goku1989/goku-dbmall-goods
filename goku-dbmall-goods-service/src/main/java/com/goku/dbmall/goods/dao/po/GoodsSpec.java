package com.goku.dbmall.goods.dao.po;

import com.goku.foundation.utils.BasePO;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name="goods_spec")
public class GoodsSpec extends BasePO {
    private String gkcode;

    private String goodsGkcode;

    private String name;

    private Long stock;

    private BigDecimal discounts;

    private BigDecimal priceDiscount;

    private BigDecimal priceNormal;

}