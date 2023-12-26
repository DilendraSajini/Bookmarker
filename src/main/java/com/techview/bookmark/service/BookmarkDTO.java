package com.techview.bookmark.service;

import java.time.Instant;

import org.springframework.stereotype.Component;

public class BookmarkDTO {

	private Long id;
	private String title;
	private String url;
	private Instant createdAt;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	public BookmarkDTO() {}
	
	public BookmarkDTO(Long id, String title, String url, Instant createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.createdAt = createdAt;
	}
}
