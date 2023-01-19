package ro.mycode.bookmanagement.service;

import org.springframework.stereotype.Service;
import ro.mycode.bookmanagement.Exceptii.ExceptieCarteaDejaExista;
import ro.mycode.bookmanagement.model.Book;
import ro.mycode.bookmanagement.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void afisare(){
        List<Book> books = bookRepository.findAll();
        books.forEach(b-> System.out.println(b));
    }

    public void add(Book book) throws ExceptieCarteaDejaExista {
        Optional<Book> pers = bookRepository.findByAutor(book.getAutor());
        if(pers.equals(Optional.empty())){
            bookRepository.save(book);
        }else{
            throw  new ExceptieCarteaDejaExista();
        }
    }

    public List<Book> getCartiInainteDe(int an){
        return  bookRepository.getCartiInainteDe(an).get();
    }

    public  List<Book> getCarteCuMultePagini(){
        return bookRepository.getCarteCuMultePagini().get();
    }

    public List<Book> getCartiNumeAutorB(String autor){
        return bookRepository.getCartiNumeAutorB(autor).get();
    }
}
