package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController 
{
	private static Logger LOGGER=LoggerFactory.getLogger(MenuItemController.class);
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping()
	public List<MenuItem> getAllMenuItems()
	{
		LOGGER.info("START:MenuItemController getAllMenuItems()");
		LOGGER.info("END:MenuItemController getAllMenuItems()");
		return menuItemService.getMenuItemListCustomer();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id)
	{
		LOGGER.info("START:MenuItemController getMenuItem()");
		LOGGER.info("END:MenuItemController getMenuItem()");
		return menuItemService.getMenuItem(id);
	}
	
	@PutMapping()
	public void save(@RequestBody MenuItem menuItem)
	{
		LOGGER.info("START:MenuItemController save()");
		menuItemService.save(menuItem);
		LOGGER.info("END:MenuItemController save()");	
	}
}
