package com.goku.dbmall.goods.service;


import com.goku.dbmall.goods.dto.CategoryInfoDTO;

import java.util.List;

public interface CategoryInfoService {
    List<CategoryInfoDTO> getCategories();

    Boolean insertCategory(CategoryInfoDTO categoryInfoDTO);
}
