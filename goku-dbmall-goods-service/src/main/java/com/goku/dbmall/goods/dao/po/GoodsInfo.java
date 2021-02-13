package com.goku.dbmall.goods.dao.po;

import com.goku.foundation.utils.BasePO;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name="goods_info")
public class GoodsInfo extends BasePO {
    private String gkcode;

    private String goodsCode;

    private String goodsName;

    private String goodsParentGkcode;

    private String catGkcode;

    private Long sellCounts;

    private Byte onOffStatus;

    private String content;

}