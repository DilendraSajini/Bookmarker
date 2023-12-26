package com.techview.bookmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.techview.bookmark"})
public class BookmarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkerApplication.class, args);
	}

}
