package com.techview.bookmark.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.techview.bookmark.BookmarkerApplication;
import com.techview.bookmark.persistence.BookmarkJpaRepository;
import com.techview.bookmark.persistence.entity.BookmarkEntity;
import com.techview.bookmark.persistence.mappers.BookmarksDTO;

@SpringBootTest(classes = { BookmarkerApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = {
//		"spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
//}) spinup docker image
public class BookmarkControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private BookmarkJpaRepository bookmarkJpaRepository;

	private List<BookmarksDTO> bookmarks;

	@BeforeEach // cannot use BeforeAll here because @Autowire not populate static repo instance
	public void setUp() {
		bookmarkJpaRepository.deleteAll();
		bookmarks = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			BookmarkEntity bookmark = new BookmarkEntity(null, "TechView " + i,
					"https://technewview" + i + ".wordpress.com/", Instant.now());

			bookmarkJpaRepository.save(bookmark);
		}
	}

	@Test
	public void shouldGetBookMarksWithFirstPage() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypes);
		ResponseEntity<BookmarksDTO> response = restTemplate.exchange("/bookmarks", HttpMethod.GET,
				new HttpEntity<>(null, headers), BookmarksDTO.class);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assertions.assertEquals(response.getBody().getTotalElements(), 15);
		Assertions.assertEquals(response.getBody().getTotalPages(), 2);
		Assertions.assertEquals(response.getBody().getCurrentPage(), 1);
		Assertions.assertEquals(response.getBody().isFirst(), true);
		Assertions.assertEquals(response.getBody().isHasNext(), true);
		Assertions.assertEquals(response.getBody().isLast(), false);
		Assertions.assertEquals(response.getBody().isHasPrevious(), false);
	}

	@Test
	public void shouldGetBookMarksWithSecondPage() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypes);
		ResponseEntity<BookmarksDTO> response = restTemplate.exchange("/bookmarks?page=2", HttpMethod.GET,
				new HttpEntity<>(null, headers), BookmarksDTO.class);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assertions.assertEquals(response.getBody().getTotalElements(), 15);
		Assertions.assertEquals(response.getBody().getTotalPages(), 2);
		Assertions.assertEquals(response.getBody().getCurrentPage(), 2);
		Assertions.assertEquals(response.getBody().isFirst(), false);
		Assertions.assertEquals(response.getBody().isHasNext(), false);
		Assertions.assertEquals(response.getBody().isLast(), true);
		Assertions.assertEquals(response.getBody().isHasPrevious(), true);
	}

	@ParameterizedTest
	@CsvSource({ "1,15,2,1,true,true,false,false", "2,15,2,2,false,false,true,true" })
	public void shouldGetBookMarksWithSecondPage_2(int pageNo, int tE, int tP, int cP, boolean isFirst,
			boolean isHasNext, boolean isLast, boolean isHasPrevious) {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypes);
		ResponseEntity<BookmarksDTO> response = restTemplate.exchange("/bookmarks?page=" + pageNo, HttpMethod.GET,
				new HttpEntity<>(null, headers), BookmarksDTO.class);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assertions.assertEquals(response.getBody().getTotalElements(), tE);
		Assertions.assertEquals(response.getBody().getTotalPages(), tP);
		Assertions.assertEquals(response.getBody().getCurrentPage(), cP);
		Assertions.assertEquals(response.getBody().isFirst(), isFirst);
		Assertions.assertEquals(response.getBody().isHasNext(), isHasNext);
		Assertions.assertEquals(response.getBody().isLast(), isLast);
		Assertions.assertEquals(response.getBody().isHasPrevious(), isHasPrevious);
	}

}
