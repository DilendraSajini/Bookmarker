package com.techview.bookmark.persistence.mappers;

import org.springframework.stereotype.Component;

import com.techview.bookmark.persistence.entity.BookmarkEntity;
import com.techview.bookmark.service.Bookmark;

@Component
public class EntityMapper {

	public Bookmark getBookMarkfromEntity(BookmarkEntity bookmarkEntity) {
		return new Bookmark(bookmarkEntity.getId(), bookmarkEntity.getTitle(), bookmarkEntity.getUrl(),
				bookmarkEntity.getCreatedAt());
	}
}
