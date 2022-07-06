package com.apidev.firstapi.model;

import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookLibraryModelTest {

    @Test
    void create_new_record() {
        BookLibraryModel book = new BookLibraryModel(
                UUID.randomUUID().toString(),
                "ROMEO&ROMEO",
                "BOOK ABOUT ROMEO AND ROMEO",
                "books.com/romeo_romeo",
                Year.of(2022)
        );

        assertNotNull(book);
        assertEquals("ROMEO&ROMEO", book.title());
        assertTrue(book.getClass().isRecord());
        assertEquals(5,book.getClass().getRecordComponents().length);
    }
}