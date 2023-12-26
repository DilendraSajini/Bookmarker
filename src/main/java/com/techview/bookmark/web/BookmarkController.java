package com.techview.bookmark.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techview.bookmark.persistence.mappers.BookmarksDTO;
import com.techview.bookmark.service.Bookmark;
import com.techview.bookmark.service.in.BookmarkService;

@RestController
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;
	
	@GetMapping("/bookmarks")
	public BookmarksDTO getBookMarks(@RequestParam(name="page", defaultValue="1")Integer page) {
		return bookmarkService.getBookMarks(page);
	}

}
