/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

import BBK.PiJ01.common.BadInput;
import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.IOGeneric;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class AntiAircraftGame implements Exercise {
    AntiAircraftGun gun = new AntiAircraftGun();
    int[] target_coords = new int[3];
    boolean playing;
    Result r;
    
    class GameEnd extends Exception {}
    
    public String getTitle() {
        return "Anti-Aircraft Game";
    }
    
    public String getDescription() {
        return "The enemy aircraft is overhead, and conveniently we know\n"
                + "it's in an element of a 10x10x10 array.  Also, the aircraft\n"
                + "seems confused and isn't moving.  Shoot it down before its \n"
                + "pilot's phone finds GPS signal!";
    }
    
    public void run() {
        
        playing = true;
        
        while (true) {
            gun.init();
            playGame();
            
            if (!playing)
                break;
            
            System.out.print("Would you like to play again [y/n]? (n): ");
            
            try {
                if (IOGeneric.getString().toLowerCase().charAt(0) != 'y')
                    break;
            } catch (BadInput e) {
                break;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
    }
    
    private void playGame() {
        IOGeneric.printTitle("Here they come!  Try to bring down the plane!", "-");
        
        while (true) {
            try {
                    playRound();
            } catch (AntiAircraftGun.BadCoordinate e) {
                    System.out.println("That shot missed the entire 10x10x10 grid!  "
                            + "But you can keep trying...");
            } catch (BadInput e) {
                    System.out.println("Your coordinate didn't even make sense!  "
                            + "Because of you, we lost the war.\n"
                            + "Thanks.\n"
                            + "Why don't you try the 'Dividing integers' exercise instead?\n"
                            + "There's less for you to mess up.  "
                            + "I'm not saying you won't be able to, though.\n\n"
                            + "You are clearly skilled.");
                    playing = false;
                    break;
            } catch (GameEnd e) {
                break;
            }
        }
    }
    
    private void playRound() throws BadInput, AntiAircraftGun.BadCoordinate, GameEnd {
        for (int d=0; d<3; d++) {
            System.out.format("Enter a coordinate %s: ", "XYZ".charAt(d));
            target_coords[d] = IOGeneric.getInteger();
        }
        
        r = gun.fire(target_coords[0], target_coords[1], target_coords[2]);
        System.out.println(r.getMsg());
        if (r == Result.HIT)
            throw new GameEnd();
    }
}
