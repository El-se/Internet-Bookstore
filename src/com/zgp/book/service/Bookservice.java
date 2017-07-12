package com.zgp.book.service;

import java.util.List;

import com.zgp.domain.Book;

public interface Bookservice {

		List<Book> selectbooks(String cid);
	
}
