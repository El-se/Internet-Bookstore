package com.zgp.category.service;

import java.util.List;

import com.zgp.category.pojo.CategoryPojo;

public interface ICategoryService {

	List<CategoryPojo> getCategorys() throws Exception;
	
}
