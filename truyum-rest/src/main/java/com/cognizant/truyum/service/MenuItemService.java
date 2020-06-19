package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService 
{
	
	private static Logger LOGGER=LoggerFactory.getLogger(MenuItemService.class);
	@Autowired
	private MenuItemDaoCollectionImpl menuItemDao;
	
	public List<MenuItem> getMenuItemListAdmin()
	{
		LOGGER.info("START:MenuItemService getMenuItemListAdmin()");
		LOGGER.info("END:MenuItemService getMenuItemListAdmin()");
		return menuItemDao.getMenuItemListAdmin();
	}
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("START:MenuItemService getMenuItemListCustomer()");
		LOGGER.info("END:MenuItemService getMenuItemListCustomer()");
		return menuItemDao.getMenuItemListCustomer();
	}
	
	public MenuItem getMenuItem(long id)
	{
		LOGGER.info("START:MenuItemService getMenuItem()");
		LOGGER.info("END:MenuItemService getMenuItem()");
		return menuItemDao.getMenuItem(id);
	}
	
	public void save(MenuItem menuItem)
	{
		LOGGER.info("START:MenuItemService save()");
		menuItemDao.modifyMenuItem(menuItem);
		LOGGER.info("END:MenuItemService save()");
	}
}
