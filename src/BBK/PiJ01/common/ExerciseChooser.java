/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.common;

import java.util.Arrays;


/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class ExerciseChooser {
    Exercise[] exercises;
    String[] titles;
    String[] descriptions;
    
    boolean running = false;
    
    public ExerciseChooser(Exercise[] new_exercises) {
        exercises = new_exercises;
        titles = new String[exercises.length+1];
        descriptions = new String[exercises.length];
        
        for (int i=0; i<exercises.length; i++) {
            titles[i] = exercises[i].getTitle();
            descriptions[i] = exercises[i].getDescription();
        }
        
        titles[exercises.length] =  "Quit";
    }
    
    public void run() throws BadInput {
        int i;
        System.out.format("Choose which exercise to run [%d -> %d]", 1, exercises.length+1);
        while (true) {
            i = IOGeneric.chooseFromList(titles);
            
            if (i == exercises.length) {
                System.out.println("Goodbye.");
                break;
            } else if (i>=0 && i<exercises.length) {
                exercises[i].run();
            } else {
                System.out.println("That's not an option!");
            }
            
        }
    }
}
