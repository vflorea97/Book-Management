package ro.mycode.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.bookmanagement.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select b from Book b where b.anPublicatie > ?1")
    Optional<List<Book>> getCartiInainteDe(int an);

    @Query("select b from Book b order by b.numarPagini desc ")
    Optional<List<Book>> getCarteCuMultePagini();

    @Query("select b from Book b where substr(b.autor,1,1) in ('B')")
    Optional<List<Book>> getCartiNumeAutorB(String autor);

    Optional<Book> findByAutor(String model);
}
