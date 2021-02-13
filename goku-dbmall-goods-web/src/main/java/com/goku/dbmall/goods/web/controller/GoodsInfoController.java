package com.goku.dbmall.goods.web.controller;

import com.goku.dbmall.goods.dto.GoodsInfoDTO;
import com.goku.dbmall.goods.service.GoodsInfoService;
import com.goku.foundation.response.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/goodsInfo")
public class GoodsInfoController {

    @Resource
    private GoodsInfoService goodsInfoService;

    @PostMapping(value = "insertGoods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse<Boolean> insertGoods(@RequestBody GoodsInfoDTO goodsInfoDTO) {
        return new BaseResponse<>(goodsInfoService.insertGoods(goodsInfoDTO));
    }

    @GetMapping(value = "getGoods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse<Integer> getGoods() {
        return new BaseResponse<>(1);
    }
}
