package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao 
{
	private static Map<String, Cart> userCart=new HashMap<String, Cart>();
 
	private static Logger LOGGER=LoggerFactory.getLogger(CartDaoCollectionImpl.class);
	@Override
	public void addCartItem(String userid, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START:CartDaoCollectionImpl addCartItem()");
		
		MenuItemDao menuItemDao =new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		
		if(userCart.containsKey(userid))
		{
			Cart cart=userCart.get(userid);
			List<MenuItem> menuItemList=cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			cart.setTotal(cart.getTotal()+menuItem.getPrice());
			userCart.put(userid, cart);	
		}
		
		else
		{
			Cart cart=new Cart();
			List<MenuItem> menuItemList=new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			cart.setTotal(menuItem.getPrice());
			userCart.put(userid, cart);
		}
		LOGGER.info("END:CartDaoCollectionImpl addCartItem()");

	}

	@Override
	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException {
		// TODO Auto-generated method stub
		LOGGER.info("START:CartDaoCollectionImpl getAllCartItems()");
		Cart cart=userCart.get(userid);
		if(cart==null)
		{
			throw new CartEmptyException();
		}
		LOGGER.info("END:CartDaoCollectionImpl getAllCartItems()");
		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(String userid, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START:CartDaoCollectionImpl removeCartItem()");
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		
		Cart cart=userCart.get(userid);
		List<MenuItem> menuItemList=cart.getMenuItemList();
		menuItemList.remove(menuItem);
		cart.setMenuItemList(menuItemList);
		cart.setTotal(cart.getTotal()-menuItem.getPrice());
		userCart.put(userid, cart);
		LOGGER.info("END:CartDaoCollectionImpl removeCartItem()");
	}

}
