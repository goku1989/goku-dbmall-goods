package com.goku.dbmall.goods.web.controller;

import com.goku.dbmall.goods.dao.po.CategoryInfo;
import com.goku.dbmall.goods.dto.CategoryInfoDTO;
import com.goku.dbmall.goods.service.CategoryInfoService;
import com.goku.foundation.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsCategory")
public class CategoryInfoController {

    @Resource
    private CategoryInfoService categoryInfoService;

    @GetMapping(value = "getCategories", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse<List<CategoryInfoDTO>> getCategories() {
        return new BaseResponse<>(categoryInfoService.getCategories());
    }
}
