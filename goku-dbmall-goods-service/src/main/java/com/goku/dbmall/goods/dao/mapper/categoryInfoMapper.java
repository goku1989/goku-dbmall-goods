package com.goku.dbmall.goods.dao.mapper;

import com.goku.dbmall.goods.dao.po.categoryInfo;

public interface categoryInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(categoryInfo record);

    int insertSelective(categoryInfo record);

    categoryInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(categoryInfo record);

    int updateByPrimaryKey(categoryInfo record);
}