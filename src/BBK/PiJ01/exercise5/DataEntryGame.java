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
public class DataEntryGame implements Exercise {
    private Employees emp_data = new Employees();
    public static class EndDataEntry extends Exception {}
    public static class DuplicateDataEntry extends Exception {}
    
    public String getTitle() {
        return "Data entry game!";
    }
    
    public String getDescription() {
        return "1. Enter employee data\n"
                + "2. Get employees who's name begins with 'S' or has an even ID.\n"
                + "3. ?\n"
                + "4. Profit.";        
    }
    
    public void run() {
        while (true) {
            try{
                addEmployee();
            } catch (EndDataEntry e) {
                break;
            }
        }
        
        StringBuffer sbuf_begin_with_s;
        sbuf_begin_with_s = new StringBuffer();
        
        StringBuffer sbuf_even_id;
        sbuf_even_id = new StringBuffer();
        
        Employees.Tuple tuple;
        
        for (Iterator itr = emp_data.getIterator(); itr.hasNext();) {
            tuple = itr.next();
            
            if (tuple.getName().toUpperCase().startsWith("S"))
                sbuf_begin_with_s.append(String.format("\t%d|\t%s\n", tuple.getID(), tuple.getName()));
            if (tuple.getID() % 2 == 0)
                sbuf_even_id.append(String.format("\t%d|\t%s\n", tuple.getID(), tuple.getName()));
        }
        
        IOGeneric.printTitle("Employees who's name begins with 'S'", "-");
        System.out.println(sbuf_begin_with_s);
        
        IOGeneric.printTitle("Employees with even IDs:", "-");
        System.out.println(sbuf_even_id);
        
        System.out.println("You win!  Wasn't that fun?");
    }
    
    private void addEmployee() throws EndDataEntry {
        try {
            System.out.print("Enter the employee's name: ");
            String name = IOGeneric.getString();
            if (name.length() == 0)
                throw new EndDataEntry();

            System.out.print("Enter the employee's ID: ");
            int id = IOGeneric.getInteger();
            if (id == 0)
                throw new EndDataEntry();
            
            if (!emp_data.isNewID(id))
                throw new DuplicateDataEntry();
            
            emp_data.add(id, name);
            System.out.print("\n");
        } catch(BadInput e) {
            System.out.println("Data enetered incorrectly.  Try again!");
        } catch(DuplicateDataEntry e) {
            System.out.println("That ID already exists.  Try again!\n");
        }
    }

}
