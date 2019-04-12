package service;

import entity.BookEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;
    
    public List<BookEntity> getBoookList(){
        return (List<BookEntity>)bookRepo.findAll();
    }
    public BookEntity addNewBook(BookEntity book){
        return bookRepo.save(book);
    }
}
