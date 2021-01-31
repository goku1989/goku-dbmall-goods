package com.goku.dbmall.goods.service.impl;

import com.goku.dbmall.goods.dao.mapper.CategoryInfoMapper;
import com.goku.dbmall.goods.dao.po.CategoryInfo;
import com.goku.dbmall.goods.dto.CategoryInfoDTO;
import com.goku.dbmall.goods.service.CategoryInfoService;
import com.goku.foundation.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CategoryInfoServiceImpl implements CategoryInfoService {
    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Override
    public List<CategoryInfoDTO> getCategories() {
        List<CategoryInfo> categoryInfos = categoryInfoMapper.selectAll();
        return CommonUtil.convertList(categoryInfos, CategoryInfoDTO.class);
    }
}
