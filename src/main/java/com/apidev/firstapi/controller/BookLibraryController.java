package com.apidev.firstapi.controller;

import com.apidev.firstapi.model.BookLibraryModel;
import com.apidev.firstapi.repository.BookLibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookLibraryController {

    private final BookLibraryRepository repository;

    public BookLibraryController(BookLibraryRepository repository) {
        this.repository = repository;
    }

    //GET request http://www.localhost:8080/books
    @GetMapping
    public List<BookLibraryModel> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BookLibraryModel findById(@PathVariable String id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BookLibraryModel create(@Valid @RequestBody BookLibraryModel book) {
        return repository.create(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{id}")
    public void update(@RequestBody BookLibraryModel book, @PathVariable String id) {
        repository.update(book, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
