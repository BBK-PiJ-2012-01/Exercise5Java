/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.common;

import java.util.*;


/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class ExerciseChooser {
    private List<Exercise> exercises;
    private List<String> titles = new ArrayList<String>();
    private List<String> descriptions = new ArrayList<String>();
    private String question;
    
    boolean running = false;
    
    public ExerciseChooser(List<Exercise> new_exercises) throws BadInput {
        if (new_exercises.size() < 1)
            throw new BadInput("Must have at least one exercise to choose from!");
        
        exercises = new_exercises;
        exercises.add(0, new QuitExercise());
        
        for (Exercise ex : exercises) {
            titles.add(ex.getTitle());
            descriptions.add(ex.getDescription());
        }
    }
    
    public void run() throws BadInput {
        question = String.format("Choose which exercise to run [%d -> %d]%n", 0, exercises.size());
        question = IOGeneric.multiplyString("-", question.length()) + "\n" + question;
        Exercise chosen;
        
        while (true) {
            System.out.println(question);
            
            
            try {
                chosen = exercises.get( IOGeneric.chooseFromList(titles) );
                IOGeneric.printResult(chosen.getDescription());
                
                if (chosen instanceof QuitExercise)
                    return;
                else
                    chosen.run();
                
            } catch(IndexOutOfBoundsException e) {
                System.out.println("That's not an option!");
            }
        }
    }
}


class QuitExercise implements Exercise {
    public String getTitle() {
        return "Quit";
    }
    
    public String getDescription() {
        return "Goodbye.";
    }
    
    public void run() {}
}