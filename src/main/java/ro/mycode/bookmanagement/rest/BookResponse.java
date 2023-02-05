package ro.mycode.bookmanagement.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.bookmanagement.model.Book;
import ro.mycode.bookmanagement.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class BookResponse {

    private BookService bookService;

    public BookResponse(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("api/v1/book/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        log.info("REST request to get all Books");
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("api/v1/book/getCartiInainteDe")
    public ResponseEntity<List<Book>> getCartiInainteDe(){
        log.info("REST request to get all Books dupa 200");
        List<Book> books = bookService.getCartiInainteDe(2000);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("api/v1/book/getCarteCuMultePagini")
    public ResponseEntity<List<Book>> getCarteCuMultePagini(){
        log.info("REST request to get cartea cu cele mai multe pagini");
        List<Book> books = bookService.getCarteCuMultePagini();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("api/v1/book/getCartiNumeAutorB")
    public ResponseEntity<List<Book>> getCartiNumeAutorB(){
        log.info("REST request to get all Books care incep cu litera 'B'");
        List<Book> books = bookService.getCartiNumeAutorB("B");
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
}
