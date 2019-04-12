package main;

import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class Main {
    private static ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("beans.xml");
    private static BookService bookService =
                (BookService)context.getBean("bookService");
    public static void main(String[] args){
        addNewBook();
        displayBookList();
    }
    public static void addNewBook(){
        CategoryEntity category = new CategoryEntity();
        category.setId(1);
              
        BookEntity book = new BookEntity("LTC", "iViettech", category);
        BookDetailsEntity bookDetails= new 
        BookDetailsEntity("1800-1-2", 200,45.0, LocalDate.parse("2018-01-01"));
        book.setBookDetails(bookDetails);
        bookDetails.setBook(book);
        
        BookEntity newBook = bookService.addNewBook(book);
        System.out.println(newBook);
    }
    public static void displayBookList(){
        List<BookEntity> bookLits= bookService.getBoookList();
        
        for(BookEntity book: bookLits){
            System.out.println(book);
        }
    }
}
