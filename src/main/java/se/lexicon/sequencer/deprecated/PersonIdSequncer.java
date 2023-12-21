package se.lexicon.sequencer.deprecated;

public class PersonIdSequncer {

    private static int currentId;

    public static int nextId(){return currentId++;}
    public static int getCurrentId(){return currentId;}
    public static void setCurrentId(int id){currentId = id;}
}
