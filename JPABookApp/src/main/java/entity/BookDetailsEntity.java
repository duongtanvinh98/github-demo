package entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bookDetails")
public class BookDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private int numberOfPage;
    private double price;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate publishDate;
    
    @OneToOne(mappedBy = "bookDetails")
    private BookEntity book;

    public BookDetailsEntity() {
    }

    public BookDetailsEntity(String isbn, int numberOfPage, LocalDate publishDate) {
        this.isbn = isbn;
        this.numberOfPage = numberOfPage;
        this.publishDate = publishDate;
    }

    public BookDetailsEntity(int id, String isbn, int numberOfPage, double price, LocalDate publishDate) {
        this.id = id;
        this.isbn = isbn;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.publishDate = publishDate;
    }

    public BookDetailsEntity(String isbn, int numberOfPage, double price, LocalDate publishDate) {
        this.isbn = isbn;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
    
    @Override
    public String toString(){               
        String str="";
        str = str + "ISBN: " + isbn + "\n" +
                "Number Of Page: " + numberOfPage +"\n" +
                "Price: " + price + "\n" +
                "Published Date: " + publishDate+"\n";
        return str;
    }
}
