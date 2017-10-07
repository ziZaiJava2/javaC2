package com.store.service.serviceImpl;

import com.store.dto.GoodsCategoryDTO;
import com.store.mapper.CategoryMapper;
import com.store.mapper.GoodsMapper;
import com.store.model.Category;
import com.store.model.Goods;
import com.store.service.GoodsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<GoodsCategoryDTO> GoodsCategoryChange(List<Goods> l){
		List<GoodsCategoryDTO> list = new ArrayList<GoodsCategoryDTO>();
		for(Goods g :l){
			GoodsCategoryDTO goodsCategoryDTO = new GoodsCategoryDTO();
			goodsCategoryDTO.setId(g.getId());
			goodsCategoryDTO.setName(g.getName());
			goodsCategoryDTO.setCategory(categoryMapper.selectCategoryName(g.getCategory()));
			goodsCategoryDTO.setDate(g.getDate());
			goodsCategoryDTO.setPrice(g.getPrice());
			list.add(goodsCategoryDTO);
		}
		
		return list;	
	}
	
	
    public List<GoodsCategoryDTO> selectAllGoods() {
        return GoodsCategoryChange(goodsMapper.selectAllGoods());
    }

	public List<GoodsCategoryDTO> selectGoods(String goodsName,String categoryName) {
		return GoodsCategoryChange(goodsMapper.selectGoods(goodsName, categoryMapper.selectCategoryId(categoryName)));
	}
	
	public void createNewCategory(String categoryName) {
		goodsMapper.ceateCategory(categoryName);
	}
	
	public void createNewGoods(String goodsName,String categoryName,String date,double price){
		goodsMapper.createGoods(goodsName, categoryMapper.selectCategoryId(categoryName),date,price);
	}
	
	public List<GoodsCategoryDTO>selectGoodsCategory(String name){
		return GoodsCategoryChange(goodsMapper.selectGoodsCategory(name));
	}

	public List<GoodsCategoryDTO> selectCategoryGoods(String category) {	
		return GoodsCategoryChange(goodsMapper.selectCategoryGoods(categoryMapper.selectCategoryId(category)));
	}

	public void deleteGoods(int id) {
		goodsMapper.deleteGoods(id);
		
	}

	public List<Category> AllCategory() {
		return categoryMapper.selectAllCategoryName();
	}
}
