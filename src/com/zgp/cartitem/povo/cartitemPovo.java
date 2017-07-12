package com.zgp.cartitem.povo;

import java.math.BigDecimal;

import com.zgp.domain.Book;
import com.zgp.domain.CartItem;
import com.zgp.domain.User;

public class cartitemPovo extends CartItem {
	
	private Book book;
	private User user;
	private double subTotal;
	
	public double getSubTotal() {
		BigDecimal  count  = new BigDecimal(this.getQuantity()) ;
		subTotal = book.getCurrprice().multiply(count).doubleValue();
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public cartitemPovo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cartitemPovo(Book book, User user) {
		super();
		this.book = book;
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "cartitemPovo [book=" + book + ", user=" + user + ", subTotal=" + subTotal + "]";
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
