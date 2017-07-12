package com.zgp.book.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zgp.book.service.Bookservice;
import com.zgp.dao.BookMapper;
import com.zgp.domain.Book;
import com.zgp.domain.BookExample;
@Service
public class Bookserviceimpl implements Bookservice  {
	@Autowired
	private BookMapper bookMapper;
	@Override
	public List<Book> selectbooks(String cid) {
		// TODO Auto-generated method stub
		BookExample example = new BookExample();
		example.createCriteria().andCidEqualTo(cid);
		/*PageHelper.startPage(1, 10);*/
		List<Book> books = bookMapper.selectByExample(example);
		/*System.out.println(books);*/
		return books;
	}
	public List<Book> selectbyauthor(String author) {
		// TODO Auto-generated method stub
		BookExample example = new BookExample();
		example.createCriteria().andAuthorEqualTo(author);
		return bookMapper.selectByExample(example);
	}
	public List<Book> selectbypress(String press) {
		// TODO Auto-generated method stub
		BookExample example = new BookExample();
		example.createCriteria().andPressEqualTo(press);
		return bookMapper.selectByExample(example);
	}
	public List<Book> selectbybname(String bname) {
		// TODO Auto-generated method stub
		BookExample example = new BookExample();
		example.createCriteria().andBnameLike("%"+bname+"%");
		return bookMapper.selectByExample(example);
	}
	public List<Book> selectbygaoji(Book book) {
		// TODO Auto-generated method stub
		BookExample example = new BookExample();
		example.createCriteria().andAuthorLike("%"+book.getAuthor()+"%").andBnameLike("%"+book.getBname()+"%").andPressLike("%"+book.getPress()+"%");
		return bookMapper.selectByExample(example);
	}
	public Book selectbybid(String bid) {
		// TODO Auto-generated method stub
		return bookMapper.selectByPrimaryKey(bid);
	}

	

	

}
