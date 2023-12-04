package se.lexicon;

public class Main {
    public static void main(String[] args) {
        Person isak = new Person("Isak", "Lönn", "test@hotmail.com");
        Person anders = new Person("Anders", "Eriksson", "testing@hotmail.com");

        System.out.println(isak.getId());
        System.out.println(anders.getId());
    }
}