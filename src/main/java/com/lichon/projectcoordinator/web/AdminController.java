package com.lichon.projectcoordinator.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model, Principal principal) {
		System.out.println(principal.getName());
		return "admin";
	}
}
