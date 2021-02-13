package com.goku.dbmall.goods.web.controller;

import com.goku.dbmall.goods.dto.CategoryInfoDTO;
import com.goku.dbmall.goods.dto.GoodsInfoDTO;
import com.goku.dbmall.goods.service.GoodsInfoService;
import com.goku.foundation.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goodsInfo")
public class GoodsInfoController {

    @Resource
    private GoodsInfoService goodsInfoService;

    @PostMapping(value = "insertGoods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse<Boolean> insertGoods(@RequestBody GoodsInfoDTO goodsInfoDTO) {
        return new BaseResponse<>(goodsInfoService.insertGoods(goodsInfoDTO));
    }
}
