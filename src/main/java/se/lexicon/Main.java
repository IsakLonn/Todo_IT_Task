package se.lexicon;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;
import se.lexicon.sequencer.Sequencer;
import se.lexicon.util.AppRole;
import se.lexicon.util.SequencerEnum;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person isak = new Person("Isak", "Lönn", "test@hotmail.com", Sequencer.getNextId(SequencerEnum.PERSON));
        TodoItem item = new TodoItem("Groceries", "Buy groceries", isak, LocalDate.now().plusDays(7), Sequencer.getNextId(SequencerEnum.TODOITEM));
        TodoItemTask itemTask = new TodoItemTask(isak, item, Sequencer.getNextId(SequencerEnum.TODOITEMTASK));
        AppUser user = new AppUser("Isak", "Apa123", AppRole.ROLE_APP_ADMIN);
    }
}