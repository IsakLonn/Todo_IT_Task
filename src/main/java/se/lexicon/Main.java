package se.lexicon;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person isak = new Person("Isak", "Lönn", "test@hotmail.com");
        LocalDate deadline = LocalDate.now();
        deadline = deadline.plusYears(1);
        TodoItem item = new TodoItem("Task", "Description", isak, deadline);

        System.out.println(item.getSummary());
    }
}