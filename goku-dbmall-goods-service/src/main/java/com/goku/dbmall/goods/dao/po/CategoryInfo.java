package com.goku.dbmall.goods.dao.po;

import com.goku.foundation.utils.BasePO;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name="category_info")
public class CategoryInfo extends BasePO {

    private String gkcode;

    private String name;

    private String code;

    private String type;

    private String parentGkcode;

    private String logo;

    private String slogan;

    private String catImage;

    private String bgColor;

    private Integer sortIndex;
}