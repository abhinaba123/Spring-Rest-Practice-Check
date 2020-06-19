package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	private static Logger LOGGER=LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	private CartDaoCollectionImpl cartDao;
	
	public void addCartItem(String userid, long menuItemId)
	{
		LOGGER.info("START:CartService addCartItem()");
		cartDao.addCartItem(userid, menuItemId);
		LOGGER.info("END:CartService addCartItem()");
	}
	
	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException
	{
		LOGGER.info("START:CartService getAllCartItems()");
		LOGGER.info("END:CartService getAllCartItems()");
		return cartDao.getAllCartItems(userid);
	}
	
	public void removeCartItem(String userid, long menuItemId)
	{
		LOGGER.info("START:CartService removeCartItem()");
		cartDao.removeCartItem(userid, menuItemId);
		LOGGER.info("END:CartService removeCartItem()");
	}
}
