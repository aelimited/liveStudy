package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    //전체 리스트 가져오기
    public List<Book> getList() {
        return repository.findAll();
    }

    //저장하기 메서드 만들기
    public Book register(Book book) {
        return repository.save(book);
    }

    // 특정 레코드 가져오기
    public Book getById(Long id) {
        Optional<Book> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    @Transactional
    public Book update(Long id, Book requestBook) {
        Optional<Book> optional = repository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get(); //영속성 메모리
            book.setTitle(requestBook.getTitle());
            book.setPrice(requestBook.getPrice());
            return book;
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }//

    }

    public void getByDelete(Long id){
        repository.deleteById(id);
    }
}
