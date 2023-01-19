package ro.mycode.bookmanagement.Exceptii;

public class ExceptieCarteaNeexistenta extends Exception{

    public ExceptieCarteaNeexistenta() {
        super("Cartea nu exista in baza de date");
    }
}
