/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

import BBK.PiJ01.common.IOGeneric;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class AntiAircraftGun {
    private int[] pos = new int[3];
    public static class BadCoordinate extends Exception {}
    
    public AntiAircraftGun() {
        init();
    }
    
    public void init() {
        for (int d=0; d<3; d++){
            pos[d] = (int) Math.abs(Math.random() * 10);
        }
        System.out.format("Aircraft is at %s\n", IOGeneric.intListToString(pos));
    }
    
    public Result fire(int ...coords) throws BadCoordinate {
        if (coords.length != 3)
            throw new BadCoordinate();
        
        for (int d=0; d<3; d++) {
            if (coords[d] < 0 || coords[d] >= 10) {
                throw new BadCoordinate();
            } else {
                coords[d] = pos[d] - coords[d];
            }
        }
        
        for (Result r : Result.values()) {
            if (r.isValidFor(coords))
                return r;
        }
        
        throw new BadCoordinate();
    }
}
