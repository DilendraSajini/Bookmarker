package com.techview.bookmark.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.techview.bookmark.persistence.entity.BookmarkEntity;
import com.techview.bookmark.persistence.mappers.BookmarksDTO;
import com.techview.bookmark.persistence.mappers.EntityMapper;
import com.techview.bookmark.service.Bookmark;
import com.techview.bookmark.service.out.BookmarkRepository;

import jakarta.transaction.Transactional;

@Transactional
@Component
public class BookmarkRepositoryProxy implements BookmarkRepository{

	@Autowired
	private BookmarkJpaRepository bookmarkJpaRepository;
	
	@Autowired
	private EntityMapper entityMapper;
	
	@Override
	public BookmarksDTO getBookMarks(Pageable pageable){
		Page<BookmarkEntity> entityList = bookmarkJpaRepository.findAll(pageable);
		List<Bookmark> bookmarkList = entityList.getContent().stream().map(e->  entityMapper.getBookMarkfromEntity(e)).collect(Collectors.toList()); 

		return new BookmarksDTO(entityList, bookmarkList);
				}
}
