package com.techview.bookmark.persistence.mappers;

import java.util.List;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techview.bookmark.persistence.entity.BookmarkEntity;
import com.techview.bookmark.service.Bookmark;

public class BookmarksDTO {

	private List<Bookmark> data;
	private long totalElements;
	private int totalPages;
	private int currentPage;
	@JsonProperty("isFirst")
	private boolean isFirst;
	@JsonProperty("isLast")
	private boolean isLast;
	private boolean hasNext;
	private boolean hasPrevious;

	public List<Bookmark> getData() {
		return data;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public boolean isLast() {
		return isLast;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setData(List<Bookmark> data) {
		this.data = data;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public BookmarksDTO(Page<BookmarkEntity> bookmarkPage, List<Bookmark> bookmarkList) {
		this.setData(bookmarkList);
		this.setTotalElements(bookmarkPage.getTotalElements());
		this.setTotalPages(bookmarkPage.getTotalPages());
		this.setCurrentPage(bookmarkPage.getNumber() + 1);
		this.setFirst(bookmarkPage.isFirst());
		this.setLast(bookmarkPage.isLast());
		this.setHasNext(bookmarkPage.hasNext());
		this.setHasPrevious(bookmarkPage.hasPrevious());
	}
}
