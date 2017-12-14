package com.ggjj.zhzz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.service.LocService;


@Controller
@RequestMapping(value = "/loc")
public class LocController {

	@Autowired
	private LocService locService;

	@RequestMapping(value = "/findAll")
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Loc> list = locService.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/loc/loc.jsp").forward(request,
				response);

	}

	@RequestMapping(value = "/delete/{loc}")
	public String delete(@PathVariable Integer loc) {
		locService.delete(loc);
		return "redirect:/loc/findAll";
	}

	@RequestMapping(value = "/insert")
	public String insert(Loc loc) {
		locService.insert(loc);
		return "redirect:/loc/findAll";
	}

	@RequestMapping("/toUpdateLocPage/{loc}")
	public void toUpdateLocPage(@PathVariable("loc") Integer locid,
			HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		Loc loc = locService.findLocByLoc(locid);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/jsp/loc/updateLoc.jsp").forward(request,
				response);

	}

	@RequestMapping(value = "/update")
	public String update(Loc loc) {
		locService.update(loc);
		return "redirect:/loc/findAll";
	}

}
