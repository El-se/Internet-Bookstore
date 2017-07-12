package com.zgp.book.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgp.book.serviceimpl.Bookserviceimpl;
import com.zgp.domain.Book;

@Controller
public class BookController {
	@Autowired
	private Bookserviceimpl bookserviceimpl;
	
	@RequestMapping(value="/getbooks/{cid}")
	public String getbooks(@PathVariable String cid,Model model,Integer pageNum,HttpSession session){
		session.setAttribute("cid", cid);
		PageHelper.startPage(pageNum, 12);
		List<Book> books = bookserviceimpl.selectbooks(cid);
		PageInfo<Book> info = new PageInfo<Book>(books);
		model.addAttribute("info", info);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}
	
	@RequestMapping(value="/selectbyauthor/{author}")
	public String selectbyauthor(@PathVariable String author,Model model) throws Exception{
		author = new String(author.getBytes("iso8859-1"), "utf-8");
		List<Book> books = bookserviceimpl.selectbyauthor(author);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}
	
	@RequestMapping(value="/selectbypress")
	public String selectbypress(String press,Model model) throws Exception{
		press = new String(press.getBytes("iso8859-1"), "utf-8");
		List<Book> books = bookserviceimpl.selectbypress(press);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}
	
	@RequestMapping(value="/selectbybname")
	public String selectbybname(String bname,Model model) throws Exception{
		bname = new String(bname.getBytes("iso8859-1"), "utf-8");
		List<Book> books = bookserviceimpl.selectbybname(bname);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}
	
	@RequestMapping(value="/selectgaoji")
	public String selectgaoji(Book book,Model model) throws Exception{
		String bname = book.getBname();
		String press = book.getPress();
		String author = book.getAuthor();
		bname = new String(bname.getBytes("iso8859-1"), "utf-8");
		press = new String(press.getBytes("iso8859-1"), "utf-8");
		author = new String(author.getBytes("iso8859-1"), "utf-8");
		book.setBname(bname);
		book.setPress(press);
		book.setAuthor(author);
		List<Book> books = bookserviceimpl.selectbygaoji(book);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}
	
	@RequestMapping(value="/selectbid/{bid}")
	public String selectbid(@PathVariable String bid,Model model) throws Exception{
		Book book = bookserviceimpl.selectbybid(bid);
		model.addAttribute("book", book);
		return "jsps/book/desc";
	}
	
}
