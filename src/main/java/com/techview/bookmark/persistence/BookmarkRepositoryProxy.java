package com.techview.bookmark.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.techview.bookmark.persistence.mappers.BookmarksDTO;
import com.techview.bookmark.persistence.mappers.BookmarkMapper;
import com.techview.bookmark.service.BookmarkDTO;
import com.techview.bookmark.service.out.BookmarkRepository;

import jakarta.transaction.Transactional;

@Transactional
@Component
public class BookmarkRepositoryProxy implements BookmarkRepository{

	@Autowired
	private BookmarkJpaRepository bookmarkJpaRepository;
	
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	@Override
	public BookmarksDTO getBookMarks(Pageable pageable){
		//Page<BookmarkEntity> entityList = bookmarkJpaRepository.findAll(pageable);
		//List<BookmarkDTO> bookmarkList = entityList.getContent().stream().map(e->  bookmarkMapper.getBookMarkfromEntity(e)).collect(Collectors.toList()); 
		Page<BookmarkDTO> bookmarkPage =  bookmarkJpaRepository.findAllProjectedToBookmarkDTO(pageable);
		return new BookmarksDTO(bookmarkPage);
				}
}
