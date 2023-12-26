package com.techview.bookmark.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.techview.bookmark.persistence.mappers.BookmarksDTO;
import com.techview.bookmark.service.in.BookmarkService;
import com.techview.bookmark.service.out.BookmarkRepository;

public class BookmarkServiceImpl implements BookmarkService {

	private BookmarkRepository bookmarkRepository;

	public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}

	@Override
	public BookmarksDTO getBookMarks(Integer page) {
		int pageNo = page < 1 ? 0 : page - 1;
		Pageable pageable = PageRequest.of(pageNo, 10, Direction.DESC, "createdAt");
		return bookmarkRepository.getBookMarks(pageable);

	}

}
