package com.store.service;

import com.store.dto.GoodsCategoryDTO;
import com.store.model.Category;
import com.store.model.Goods;

import java.util.List;

public interface GoodsService {
    public List<GoodsCategoryDTO> selectAllGoods();
    
    public List<GoodsCategoryDTO> selectGoodsCategory(String name);
    
    public List<GoodsCategoryDTO> selectCategoryGoods(String category);
    
    public List<GoodsCategoryDTO>selectGoods(String goodsName,String categortName);
    
    public void createNewCategory(String categoryName);
    
    public void createNewGoods(String goodsName,String categoryName,String date,double price);
    
    public void deleteGoods(int id);

    public List<Category> AllCategory();
}
