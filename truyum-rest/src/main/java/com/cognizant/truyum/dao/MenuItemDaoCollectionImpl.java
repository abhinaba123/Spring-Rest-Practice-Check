package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	private static Logger LOGGER=LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	
	private static List<MenuItem> menuItemList = null;

	@SuppressWarnings({ "resource", "unchecked" })
	public MenuItemDaoCollectionImpl() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = context.getBean("menuItems", ArrayList.class);
	
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		LOGGER.info("START:MenuItemDaoCollectionImpl getMenuItemListAdmin()");
		LOGGER.info("END:MenuItemDaoCollectionImpl getMenuItemListAdmin()");
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		LOGGER.info("START:MenuItemDaoCollectionImpl getMenuItemListCustomer()");
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) || menuItem.getDateOfLaunch().before(new Date()))
					&& menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		LOGGER.info("END:MenuItemDaoCollectionImpl getMenuItemListCustomer()");
		return customerMenuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		LOGGER.info("START:MenuItemDaoCollectionImpl modifyMenuItem()");
		for(MenuItem item:menuItemList)
		{
			if(item.getId()==menuItem.getId())
			{
				item.setName(menuItem.getName());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setCategory(menuItem.getCategory());
				item.setFreeDelivery(menuItem.isFreeDelivery());
			}
		}
		LOGGER.info("END:MenuItemDaoCollectionImpl modifyMenuItem()");

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START:MenuItemDaoCollectionImpl getMenuItem()");
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		LOGGER.info("END:MenuItemDaoCollectionImpl getMenuItem()");
		return menuItem;
	}

}
