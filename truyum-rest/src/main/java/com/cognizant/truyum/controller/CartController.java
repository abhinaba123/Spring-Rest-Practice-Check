package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Controller
@RequestMapping("/carts")
public class CartController {

	private static Logger LOGGER=LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{userid}/{menuItemId}")
	public void addCartItem(@PathVariable String userid,@PathVariable long menuItemId)
	{
		LOGGER.info("START:CartController addCartItem()");
		cartService.addCartItem(userid, menuItemId);
		LOGGER.info("END:CartController addCartItem()");
	}
	
	@GetMapping("/{userid}")
	public List<MenuItem> getAllCartItems(@PathVariable String userid) throws CartEmptyException
	{
		LOGGER.info("START:CartController getAllCartItems()");
		LOGGER.info("END:CartController getAllCartItems()");
		return cartService.getAllCartItems(userid);
	}
	
	@DeleteMapping("/{userid}/{menuItemId}")
	public void removeCartItem(@PathVariable String userid,@PathVariable long menuItemId)
	{
		LOGGER.info("START:CartController removeCartItem()");
		cartService.removeCartItem(userid, menuItemId);
		LOGGER.info("END:CartController removeCartItem()");
	}
	
	
}
