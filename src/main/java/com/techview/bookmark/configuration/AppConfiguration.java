package com.techview.bookmark.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techview.bookmark.service.BookmarkServiceImpl;
import com.techview.bookmark.service.out.BookmarkRepository;

@Configuration
public class AppConfiguration {
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@Bean
	public BookmarkServiceImpl getBookmarkService() {
		return new BookmarkServiceImpl(bookmarkRepository);
	}
	
}
