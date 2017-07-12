package com.zgp.category.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgp.category.dao.CategoryMapperImpl;
import com.zgp.category.pojo.CategoryPojo;
import com.zgp.category.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapperImpl categoryMapperImpl;
	@Override
	public List<CategoryPojo> getCategorys() throws Exception {
		
		return categoryMapperImpl.selectAllCategorys();
		
	}

}
