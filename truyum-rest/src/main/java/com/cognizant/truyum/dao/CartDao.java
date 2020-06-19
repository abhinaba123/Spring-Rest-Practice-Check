package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao 
{
	public void addCartItem(String userid,long menuItemId);
	
	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException;
	
	public void removeCartItem(String userid,long menuItemId);
	
}
