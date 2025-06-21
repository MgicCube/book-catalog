package com.my.bookcatalog;

import com.my.bookcatalog.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 集成测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetBooks() {
        ResponseEntity<Book[]> response = restTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetBook() {
        Book book = createBook();
        ResponseEntity<Book> response = restTemplate.getForEntity("/api/books/{id}", Book.class,book.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private Book createBook() {
        Book newBook = new Book();
        newBook.setTitle("testTitle");
        newBook.setAuthor("xxxAuther");
        newBook.setGenre("文学类");
        newBook.setYearPublished(2025);

        ResponseEntity<Book> response = restTemplate.postForEntity(
                "/api/books",
                newBook,
                Book.class
        );
        return response.getBody();
    }

    @Test
    void testCreateBooks() {
        Book book = createBook();
        assertEquals("testTitle", book.getTitle());
    }

    @Test
    void testUpdateBooks() {
        Book book = createBook();
        HttpEntity<Book> entity = new HttpEntity<>(book);
        ResponseEntity<Book> response = restTemplate.exchange(
                "/api/books/{id}",
                HttpMethod.PUT,
                entity,
                Book.class,
                book.getId()
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("testTitle", response.getBody().getTitle());
    }

    @Test
    void testDeleteBooks() {
        Book book = createBook();
        // 构造请求
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        // 执行 DELETE 请求
        ResponseEntity<Void> response = restTemplate.exchange(
                "/api/books/{id}",
                HttpMethod.DELETE,
                requestEntity,
                Void.class,
                book.getId()
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
