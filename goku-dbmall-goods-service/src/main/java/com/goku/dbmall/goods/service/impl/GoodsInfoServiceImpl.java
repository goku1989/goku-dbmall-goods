package com.goku.dbmall.goods.service.impl;

import com.goku.dbmall.goods.dao.mapper.GoodsInfoMapper;
import com.goku.dbmall.goods.dao.po.GoodsInfo;
import com.goku.dbmall.goods.dto.GoodsInfoDTO;
import com.goku.dbmall.goods.service.GoodsInfoService;
import com.goku.foundation.utils.CommonUtil;
import com.goku.foundation.utils.POUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.goku.dbmall.goods.common.constant.CustomConstants.GK_GOODS;
import static com.goku.foundation.constant.NumberConstant.BYTE_ONE;

@Slf4j
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public Boolean insertGoods(GoodsInfoDTO goodsInfoDTO) {
        GoodsInfo goodsInfo = CommonUtil.convert(goodsInfoDTO, GoodsInfo.class);
        POUtils.initCreatPO(goodsInfo);
        goodsInfo.setGkcode(GK_GOODS + CommonUtil.getIdByUUId());
        goodsInfo.setSellCounts(0L);
        goodsInfo.setOnOffStatus(BYTE_ONE);
        goodsInfoMapper.insert(goodsInfo);
        return true;
    }
}
