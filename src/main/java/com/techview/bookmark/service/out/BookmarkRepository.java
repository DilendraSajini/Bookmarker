package com.techview.bookmark.service.out;

import org.springframework.data.domain.Pageable;

import com.techview.bookmark.persistence.mappers.BookmarksDTO;

public interface BookmarkRepository {

	BookmarksDTO getBookMarks(Pageable pageable);

}
