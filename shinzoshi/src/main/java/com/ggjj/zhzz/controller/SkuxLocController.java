package com.ggjj.zhzz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggjj.zhzz.service.SkuxLocService;

@Controller
@RequestMapping(value = "/skuxLoc")
public class SkuxLocController {

	@Autowired
	private SkuxLocService skuxLocService;
	
	@RequestMapping("/findSkuxLoc")
	public void findSkuxLoc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", skuxLocService.findSkuxLoc());
		request.getRequestDispatcher("/jsp/common/skuxLoc.jsp").forward(request,
				response);
		
	}

}
