package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookRestController {
	
	@Autowired
	BookService bookService ;
	
	/*@RequestMapping(value = /book/{"name"}, method = RequestMethod.POST)
	public String getBook(@Valid @ModelAttribute("userform") UserForm userform, BindingResult result,
			ModelMap model) {

		User user = bookService.(userform.getFname());
		String view;
		// Should have used an optional here
		if (user != null) {
			view = "manage";
		} else {
			view = "welcome";
		}
		return view;
	}*/

}
