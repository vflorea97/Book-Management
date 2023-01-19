package ro.mycode.bookmanagement.Exceptii;

public class ExceptieCarteaDejaExista extends Exception{

    public ExceptieCarteaDejaExista(){
        super("Cartea exista deja in baza de date");
    }
}
