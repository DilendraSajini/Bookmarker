package com.techview.bookmark.persistence.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="bookmarks")
public class BookmarkEntity {

	@Id
	@SequenceGenerator(name= "bm_id_seq_gen", sequenceName ="bm_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "bm_id_seq_gen")
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public BookmarkEntity() {
		
	}
	
	public BookmarkEntity(Long id, String title, String url, Instant createdAt) {
	    this.id = id;
	    this.title = title;
	    this.url = url;
	    this.createdAt = createdAt;
	}
}
