package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import com.library.book.domain.Book;
import com.library.book.domain.BookAuthor;
import com.library.book.domain.User;




@SpringBootApplication(scanBasePackages={"com.library"})
@EntityScan(basePackageClasses={User.class,Book.class,BookAuthor.class})
public class SpringBootWebApplication extends SpringBootServletInitializer implements CommandLineRunner{
	
	@Autowired
	ApplicationContext appContext;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
/*		
		BookService bookSvc = appContext.getBean(BookService.class);
		Book book = appContext.getBean(Book.class);*/
		User user = appContext.getBean(User.class);
		user = createUser(user);
		UserService useSvc = appContext.getBean(UserService.class);
		useSvc.registerUserDetails(user);
	}
	
	private User createUser(User user) {
		user.setFname("Shyamala");
		user.setLname("K");
		user.setAddress_1("Chennai");
		user.setZip("600122");
		//user.setType(UserType.BOTH);
		
		return user;
	}
	
	private Book createBook(Book book) {
		return null;
/*		book.setAcademicclass("JAVA");
		book.setBookisbnno("1234DDNT");
		book.setGenre("TECHNICAL");
		book.setStatus(true);
		book.setTitle("JAVA IN ACTION");
		book.setUser(user);
		bookSvc.saveBook(book);*/
	}

}