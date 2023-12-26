package com.techview.bookmark.persistence.mappers;

import org.springframework.stereotype.Component;

import com.techview.bookmark.persistence.entity.BookmarkEntity;
import com.techview.bookmark.service.BookmarkDTO;

@Component
public class BookmarkMapper {

	public BookmarkDTO getBookMarkfromEntity(BookmarkEntity bookmarkEntity) {
		return new BookmarkDTO(bookmarkEntity.getId(), bookmarkEntity.getTitle(), bookmarkEntity.getUrl(),
				bookmarkEntity.getCreatedAt());
	}
}
