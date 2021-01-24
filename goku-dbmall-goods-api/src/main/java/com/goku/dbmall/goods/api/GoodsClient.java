package com.goku.dbmall.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("goku-dbmall-goods")
public interface GoodsClient {
    @GetMapping(value = "/goodsCategory/getCategories")
    Boolean getCategories();
}
