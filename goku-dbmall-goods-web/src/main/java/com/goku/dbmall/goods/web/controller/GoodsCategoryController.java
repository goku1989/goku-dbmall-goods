package com.goku.dbmall.goods.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {

    @GetMapping(value = "getCategories", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean getCategories() {
        return true;
    }
}
