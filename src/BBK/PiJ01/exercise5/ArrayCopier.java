/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

import BBK.PiJ01.common.IOGeneric;
import BBK.PiJ01.common.Exercise;
import java.lang.Math;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class ArrayCopier implements Exercise {
    public void copy(int[] src, int[] dst) {
        
        int smallest_size = Math.min(dst.length, src.length);
        for (int i=0; i<smallest_size; i++) {
            dst[i] = src[i];
        }
        
        if (dst.length > src.length) {
            for (int i=smallest_size;  i<dst.length; i++) {
                dst[i] = 0;
            }
        }
    }
    
    private void copyAndPrint(int[] src, int[] dst) {
        System.out.format("Copy from src = %s to dst = %s :\n", 
                                            IOGeneric.intListToString(src), 
                                            IOGeneric.intListToString(dst));
        copy(src, dst);
        System.out.format("\t\t => dst = %s\n", IOGeneric.intListToString(dst));
    }
    
    
    
    public String getTitle() {
        return "Array Copier";
    }
    
    public String getDescription() {
        return "Copies contents of one array to another,\n"
                + "modulo the length of the destination list.\n"
                + "Empty spaces are filled with zeros.";
    }
    
    public void run() {
        copyAndPrint(new int[]{1,2,3}, new int[]{5,6,7});
        copyAndPrint(new int[]{1,2,3, 4}, new int[]{5,6,7});
        copyAndPrint(new int[]{1,2,3}, new int[]{5,6,7, 8});
    }
}
