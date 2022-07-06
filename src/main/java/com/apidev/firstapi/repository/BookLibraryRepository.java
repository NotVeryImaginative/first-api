package com.apidev.firstapi.repository;

import com.apidev.firstapi.model.BookLibraryModel;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookLibraryRepository {
    List <BookLibraryModel> books = new ArrayList<>();

    public BookLibraryRepository(){
        books.add( new BookLibraryModel(
                UUID.randomUUID().toString(),
                "ROMEO&ROMEO",
                "BOOK ABOUT ROMEO AND ROMEO",
                "books.com/romeo_romeo",
                Year.of(2022)
                )
        );
    }

    public List<BookLibraryModel> findAll()
    {
        return books;
    }

    public BookLibraryModel findById(String Id){
        return books.stream().filter(book -> book.id().equals(Id)).findFirst().orElse(null);
    }

    public BookLibraryModel create(BookLibraryModel book){
        books.add(book);
        return book;
    }

    public void update(BookLibraryModel book, String id){
        BookLibraryModel existing = books.stream().filter(b -> b.id().equals(id)).findFirst().
                orElseThrow(() -> new IllegalArgumentException("Book not found"));
        int i = books.indexOf(existing);
        books.set(i, book);
    }

    public void delete(String id){
        books.removeIf(book -> book.id().equals(id));
    }
}