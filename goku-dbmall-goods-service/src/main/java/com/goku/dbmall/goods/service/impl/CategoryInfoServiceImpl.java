package com.goku.dbmall.goods.service.impl;

import com.goku.dbmall.goods.dao.mapper.CategoryInfoMapper;
import com.goku.dbmall.goods.dao.po.CategoryInfo;
import com.goku.dbmall.goods.dto.CategoryInfoDTO;
import com.goku.dbmall.goods.service.CategoryInfoService;
import com.goku.foundation.utils.CommonUtil;
import com.goku.foundation.utils.POUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.goku.dbmall.goods.common.constant.CustomConstants.*;
import static com.goku.foundation.constant.NumberConstant.*;
import static com.goku.foundation.constant.SymbolConstant.STRING_COMMA;

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
        List<CategoryInfoDTO> categoryInfoDTOS = CommonUtil.convertList(categoryInfos, CategoryInfoDTO.class);
        return list2Tree(categoryInfoDTOS);
    }

    @Override
    public Boolean insertCategory(CategoryInfoDTO categoryInfoDTO) {
        CategoryInfo categoryInfo = CommonUtil.convert(categoryInfoDTO, CategoryInfo.class);
        String name = categoryInfo.getName().trim();
        categoryInfo.setName(name);

        List<CategoryInfo> names = categoryInfoMapper.selectByExample(Example.builder(CategoryInfo.class)
                .where(WeekendSqls.<CategoryInfo>custom()
                        .andEqualTo(CategoryInfo::getDeleted, NOT_DELETE)
                        .andEqualTo(CategoryInfo::getName, name))
                .build());
        if (CollectionUtils.isNotEmpty(names)) {
            return false;
        }


        POUtils.initCreatPO(categoryInfo);
        String gkcode = GK_CATEGORY + CommonUtil.getIdByUUId();
        categoryInfo.setGkcode(gkcode);
        if ("-1".equals(categoryInfoDTO.getGkcodeTreePath()) || StringUtils.isEmpty(categoryInfoDTO.getGkcodeTreePath())) {
            categoryInfo.setGkcodeTreePath(gkcode);
        } else {
            categoryInfo.setGkcodeTreePath(categoryInfoDTO.getGkcodeTreePath() + STRING_COMMA + gkcode);
        }
        if (null == categoryInfo.getSortIndex()) {
            List<CategoryInfo> categoryInfos = categoryInfoMapper.selectByExample(Example.builder(CategoryInfo.class)
                    .where(WeekendSqls.<CategoryInfo>custom()
                            .andEqualTo(CategoryInfo::getDeleted, NOT_DELETE)
                            .andEqualTo(CategoryInfo::getParentGkcode, categoryInfo.getParentGkcode()))
                    .build());
            if (CollectionUtils.isEmpty(categoryInfos)) {
                categoryInfo.setSortIndex(0);
            } else {
                CategoryInfo info = categoryInfos.stream().max(Comparator.comparing(CategoryInfo::getSortIndex)).get();
                categoryInfo.setSortIndex(info.getSortIndex() + 1);
            }

        }
        categoryInfoMapper.insert(categoryInfo);
        return true;
    }

    private List<CategoryInfoDTO> list2Tree(List<CategoryInfoDTO> categoryInfoDTOS) {
        return categoryInfoDTOS.stream().filter(e -> STRING_MINUS_ONE.equals(e.getParentGkcode()))
                .map(i -> findChildren(i, categoryInfoDTOS)).collect(Collectors.toList());
    }

    private CategoryInfoDTO findChildren(CategoryInfoDTO node, List<CategoryInfoDTO> allList) {
        if (node.getChildren() == null) {
            node.setChildren(Lists.newArrayList());
        }
        allList.stream()
                .filter(i -> node.getGkcode().equals(i.getParentGkcode()))
                .forEach(i -> node.getChildren().add(findChildren(i, allList)));
        return node;
    }
}
