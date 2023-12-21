package se.lexicon.sequencer;

import se.lexicon.util.SequencerEnum;

import java.util.HashMap;

public class Sequencer {

    private static HashMap<SequencerEnum, Integer> sequencerIDS = new HashMap<>();

    public static int getNextId(SequencerEnum sequencerEnum){
        if(sequencerIDS.containsKey(sequencerEnum)){
            sequencerIDS.put(sequencerEnum, sequencerIDS.get(sequencerEnum) + 1);
            return sequencerIDS.get(sequencerEnum);
        }
        else sequencerIDS.put(sequencerEnum, 0);
        return 0;
    }

    public static int getCurrentId(SequencerEnum sequencerEnum){
        if(sequencerIDS.containsKey(sequencerEnum)) return sequencerIDS.get(sequencerEnum);
        else{
            sequencerIDS.put(sequencerEnum, 0);
            return 0;
        }
    }

    public static void setId(int id, SequencerEnum sequencerEnum){ sequencerIDS.put(sequencerEnum, 0); }

}
