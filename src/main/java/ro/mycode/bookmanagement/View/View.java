package ro.mycode.bookmanagement.View;

import org.springframework.stereotype.Component;
import ro.mycode.bookmanagement.Exceptii.ExceptieCarteaDejaExista;
import ro.mycode.bookmanagement.model.Book;
import ro.mycode.bookmanagement.repository.BookRepository;
import ro.mycode.bookmanagement.service.BookService;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class View {

    private BookService bookService;
    private Scanner scanner;
    private final BookRepository bookRepository;


    public View(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        scanner = new Scanner(System.in);
        this.bookRepository = bookRepository;
    }

    public void meniu() {
        System.out.println("Apasa 1 pentru a afisa toate cartile");
        System.out.println("Apasa 2 penru a adauga o carte");
        System.out.println("Apasa 3 pentru a afisa cartile publicate dupa anul 2000");
        System.out.println("Apasa 4 pentru a afisa cartea cu cele mai multe pagini");
        System.out.println("Apasa 5 pentru a afisa cartile unde numele autorului incepe cu litera 'B'");

    }

    public void play() {
        boolean run = true;
        meniu();
        while (run) {
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton) {
                case 1:
                    bookService.afisare();
                    break;
                case 2:
                    addPersoana();
                    break;
                case 3:
                    getCartiInainteDe();
                    break;
                case 4:
                    getCarteCuMultePagini();
                    break;
                case 5:
                    getCartiNumeAutorB();
                    break;
                default:
                    run = false;
                    break;
            }
        }
    }

    public void addPersoana() {
        System.out.println("Introdu numele:");
        String nume = scanner.nextLine();
        System.out.println("Introdu numele autorului:");
        String autor = scanner.nextLine();
        System.out.println("Introdu anul publicarii: ");
        int anPublicatie = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu numarul de pagini: ");
        int numarpagini = Integer.parseInt(scanner.nextLine());
        try {
            Book book = Book.builder().nume(nume).autor(autor).anPublicatie(anPublicatie).numarPagini(numarpagini).build();
            bookService.add(book);
            System.out.println("Ai adaugat o carte cu succes!!");
        } catch (ExceptieCarteaDejaExista b) {
            System.err.println(b.getMessage());
        }
    }

    public void getCartiInainteDe(){
        Optional<List<Book>> books = bookRepository.getCartiInainteDe(2000);
        for (int i = 0; i < books.get().size(); i++) {
            System.out.println(books.get().get(i));
        }
    }

    public void  getCarteCuMultePagini() {
        Optional<List<Book>> books = bookRepository.getCarteCuMultePagini();
        for (int i = 0; i < books.get().size(); i++) {
            System.out.println(books.get().get(i));
        }
    }

    public void getCartiNumeAutorB() {
        Optional<List<Book>> books = bookRepository.getCartiNumeAutorB("B");
        for (int i = 0; i < books.get().size(); i++) {
            System.out.println(books.get().get(i));
        }
    }
}
