package com.techview.bookmark.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techview.bookmark.persistence.entity.BookmarkEntity;
import com.techview.bookmark.service.BookmarkDTO;

public interface BookmarkJpaRepository extends JpaRepository<BookmarkEntity, Long> {

	// JPQL DTO projection not reading unnecessary loading
	@Query("select new com.techview.bookmark.service.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from BookmarkEntity b")
	Page<BookmarkDTO> findAllProjectedToBookmarkDTO(Pageable pageable);
}
