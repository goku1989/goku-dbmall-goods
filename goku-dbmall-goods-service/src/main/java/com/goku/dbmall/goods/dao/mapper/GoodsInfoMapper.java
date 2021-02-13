package com.goku.dbmall.goods.dao.mapper;

import com.goku.dbmall.goods.dao.po.GoodsInfo;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}