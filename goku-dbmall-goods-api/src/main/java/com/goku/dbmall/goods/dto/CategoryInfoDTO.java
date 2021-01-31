package com.goku.dbmall.goods.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryInfoDTO {
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

    List<CategoryInfoDTO> children;
}
