/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public enum Result {
    HIT ("You hit it!  Well done!", new int[]{0,0,0}, new int[]{0,0,0}), 
    FAIL_LEFT ("The target is to the left!", new int[]{-1,0,0}, new int[]{0,1,1}), 
    FAIL_RIGHT ("The target is to the right!", new int[]{1,0,0}, new int[]{0,1,1}),
    FAIL_HIGH ("The target is higher!", new int[]{0,1,0}, new int[]{1,0,1}),
    FAIL_LOW ("The target is lower!", new int[]{0,-1,0}, new int[]{1,0,1}),
    FAIL_SHORT ("The target is closer!", new int[]{0,0,-1}, new int[]{1,1,0}),
    FAIL_LONG ("The target is farther!", new int[]{0,0,1}, new int[]{1,1,0}),
    
    OUT_OF_RANGE ("That shot is way out of range.  Try harder!", 
                                        new int[]{0,0,0}, new int[]{10,10,10});
    
    private int[] coords;
    private int[] margin;
    private String msg;
    
    Result(String msg, int[] coords, int[] margin) {
        assert coords.length == 3;
        this.coords = coords;
        this.margin = margin;
        this.msg = msg;
    }
    
    public boolean isValidFor(int[] test_coords) {
        assert (test_coords.length == 3);
        
        for (int d=0; d<3; d++) {
            if (Math.abs(test_coords[d] - coords[d]) > margin[d])
                return false;
        }
        return true;
    }
    
    public String getMsg() {
        return msg;
    }
}
