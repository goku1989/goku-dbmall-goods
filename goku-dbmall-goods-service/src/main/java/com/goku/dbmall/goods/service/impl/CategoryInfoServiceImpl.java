package com.goku.dbmall.goods.service.impl;

import com.goku.dbmall.goods.dao.mapper.CategoryInfoMapper;
import com.goku.dbmall.goods.dao.po.CategoryInfo;
import com.goku.dbmall.goods.dto.CategoryInfoDTO;
import com.goku.dbmall.goods.service.CategoryInfoService;
import com.goku.foundation.util.CommonUtil;
import com.goku.foundation.util.POUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

import static com.goku.dbmall.goods.common.utils.CustomConstants.*;

@Slf4j
@Service
public class CategoryInfoServiceImpl implements CategoryInfoService {
    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Override
    public List<CategoryInfoDTO> getCategories() {
        List<CategoryInfo> categoryInfos = categoryInfoMapper.selectByExample(Example.builder(CategoryInfo.class)
                .where(WeekendSqls.<CategoryInfo>custom()
                        .andEqualTo(CategoryInfo::getDeleted, NOT_DELETE))
                .orderBy(SORT_INDEX)
                .build());
        return CommonUtil.convertList(categoryInfos, CategoryInfoDTO.class);
    }

    @Override
    public Boolean insertCategory(CategoryInfoDTO categoryInfoDTO) {
        CategoryInfo categoryInfo = CommonUtil.convert(categoryInfoDTO, CategoryInfo.class);
        categoryInfo.setName(categoryInfo.getName().trim());
        POUtils.initCreatPO(categoryInfo);
        categoryInfo.setGkcode(GK_CATEGORY + CommonUtil.getIdByUUId());
        if (null == categoryInfo.getSortIndex()) {
            List<CategoryInfo> categoryInfos = categoryInfoMapper.selectByExample(Example.builder(CategoryInfo.class)
                    .where(WeekendSqls.<CategoryInfo>custom()
                            .andEqualTo(CategoryInfo::getDeleted, NOT_DELETE)
                            .andEqualTo(CategoryInfo::getParentGkcode, categoryInfo.getParentGkcode()))
                    .build());
            CategoryInfo info = categoryInfos.stream().max(Comparator.comparing(CategoryInfo::getSortIndex)).get();
            categoryInfo.setSortIndex(info.getSortIndex() + 1);
        }
        categoryInfoMapper.insert(categoryInfo);
        return true;
    }
}
