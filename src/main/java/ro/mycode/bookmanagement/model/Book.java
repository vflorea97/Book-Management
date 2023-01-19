package ro.mycode.bookmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Book")
@Table(name="book")
public class Book implements Comparable<Book>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nume;
    private String autor;
    private int anPublicatie;
    private int numarPagini;


    @Override
    public int compareTo(Book o) {
        if (this.autor.compareTo(o.autor) > 0){
            return 1;
        }
        else if(this.autor.compareTo(o.autor) < 0){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Book book = (Book) o;
        return this.autor.equals(book.autor);
    }
}
