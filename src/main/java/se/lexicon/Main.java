package se.lexicon;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person isak = new Person("Isak", "Lönn", "test@hotmail.com");
        TodoItem item = new TodoItem("Groceries", "Buy groceries", isak, LocalDate.now().plusDays(7));
        TodoItemTask itemTask = new TodoItemTask(isak, item);
        AppUser user = new AppUser("Isak", "Apa123", AppRole.ROLE_APP_ADMIN);
        System.out.println(itemTask);

        //System.out.println(isak.getSummary());
        //System.out.println(item.getSummary());
        //System.out.println(itemTask.getSummary());
    }
}