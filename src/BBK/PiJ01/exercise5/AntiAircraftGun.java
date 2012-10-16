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
    //private int[][][] grid = new int[10][10][10];
    private int[] pos = new int[3];
    class BadCoordinate extends Exception {}
    
    public AntiAircraftGun() {
        /*
        for(int k=0; k<10; k++) {
            for (int j=0; j<10; j++) {
                for (int i=0; i<10; i++){
                    grid[k][j][i] = 0;
                }
            }
        }
        */
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
