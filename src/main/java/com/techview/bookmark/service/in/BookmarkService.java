package com.techview.bookmark.service.in;

import java.util.List;

import com.techview.bookmark.persistence.mappers.BookmarksDTO;
import com.techview.bookmark.service.Bookmark;

public interface BookmarkService {

	BookmarksDTO getBookMarks(Integer page);

}
