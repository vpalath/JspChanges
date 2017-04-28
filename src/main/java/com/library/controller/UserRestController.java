package com.library.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.book.domain.User;
import com.library.book.domain.UserForm;
import com.library.book.domain.UserType;

@Controller
public class UserRestController {

	@Autowired
	UserService userService;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping(value = "/existsUser", method = RequestMethod.POST)
	public String existsUser(@Valid @ModelAttribute("userform") UserForm userform, BindingResult result,
			ModelMap model) {

		User user = userService.getUserDetails(userform.getFname());
		String view;
		// Should have used an optional here
		if (user != null) {
			view = "manage";
		} else {
			view = "welcome";
		}
		return view;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showForm(@Valid @ModelAttribute("userform") UserForm userform, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("username", userform.getFname());
		return "welcome";
	}

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {

		User userForm = new User();
		model.put("userForm", userForm);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new UserForm());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") UserForm userForm) {
		System.out.println("sasassssssssssssssssss**********");
		System.out.println(userForm.getAddress_1());
		User user = new User();
		user.setAddress_1(userForm.getAddress_1());

		user.setAddress_2(userForm.getAddress_2());
		user.setAdmin(true);
		user.setFname(userForm.getFname());
		user.setLname(userForm.getLname());
		user.setType(UserType.DONOR);
		user.setZip(userForm.getZip());

		userService.registerUserDetails(user);

		return "welcome";
	}

}
