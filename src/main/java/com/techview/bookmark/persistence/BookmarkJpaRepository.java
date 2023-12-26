package com.techview.bookmark.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techview.bookmark.persistence.entity.BookmarkEntity;

public interface BookmarkJpaRepository extends JpaRepository<BookmarkEntity, Long> {

}
