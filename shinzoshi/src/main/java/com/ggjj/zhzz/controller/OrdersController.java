package com.ggjj.zhzz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggjj.zhzz.pojo.Orders;
import com.ggjj.zhzz.service.OrdersService;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "/delete/{ordersId}")
	public String delete(@PathVariable Integer ordersId) {
		ordersService.delete(ordersId);
		return "redirect:/orders/findAll";
	}

	@RequestMapping("/toInsertPage")
	public void toInsertPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", ordersService.findAllSku());
		request.getRequestDispatcher("/jsp/orders/insertOrders.jsp").forward(
				request, response);

	}

	@RequestMapping(value = "/insert")
	public String insert(Orders orders) {
		ordersService.insert(orders);
		return "redirect:/orders/findAll";
	}

	@RequestMapping(value = "/findAll")
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", ordersService.findAll());
		request.getRequestDispatcher("/jsp/orders/orders.jsp").forward(request,
				response);

	}

}
