package com.zgp.category.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gg.beanhelper.BeanHelper;
import com.zgp.category.pojo.CategoryPojo;
import com.zgp.dao.CategoryMapper;
import com.zgp.domain.Category;
import com.zgp.domain.CategoryExample;
@Repository
public class CategoryMapperImpl {

	@Autowired
	private  CategoryMapper  categoryMapper;

	public List<CategoryPojo> selectAllCategorys() throws IllegalAccessException, InvocationTargetException {
		//\
		List<CategoryPojo>   categoryPojos = new ArrayList<CategoryPojo>();
		CategoryExample  example  = new CategoryExample();
		example.createCriteria().andPidIsNull();
		List<Category>  list= this.categoryMapper.selectByExample(example);
		//2  
		for (Category category : list) {
			CategoryPojo  pojo  = new CategoryPojo();
			BeanUtils.copyProperties(pojo, category);
			CategoryExample  example2  = new CategoryExample();
			example2.createCriteria().andPidEqualTo(category.getCid());
			List<Category> children= this.categoryMapper.selectByExample(example2);
			pojo.setChildren(children);
			
			categoryPojos.add(pojo);
		}
		
		return categoryPojos;
	}

}
