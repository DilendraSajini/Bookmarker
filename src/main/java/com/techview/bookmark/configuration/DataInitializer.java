//package com.techview.bookmark.configuration;
//
//import java.time.Instant;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.techview.bookmark.persistence.BookmarkJpaRepository;
//import com.techview.bookmark.persistence.entity.BookmarkEntity;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//	@Autowired
//	private BookmarkJpaRepository bookmarkJpaRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		bookmarkJpaRepository.save(new BookmarkEntity(null, "TechView", "https://technewview.wordpress.com/", Instant.now()));
//		for (int i = 1; i <= 15; i++) {
//            BookmarkEntity bookmark = new BookmarkEntity(
//                    null,
//                    "TechView " + i,
//                    "https://technewview" + i + ".wordpress.com/",
//                    Instant.now()
//            );
//            
//            bookmarkJpaRepository.save(bookmark);
//	}
//	}
//
//}
