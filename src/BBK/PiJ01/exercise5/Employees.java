/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Employees {
    private static int initial_size = 3;
    private Tuple[] tuples = new Tuple[initial_size];
    private int next_id = 0;
    
    static class Tuple {
        private String name;
        private int id;

        public Tuple(int id, String name) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getID() {
            return id;
        }
    }

    private void doubleCapacity() {
        Tuple[] new_tuples = new Tuple[initial_size*2];
        
        for (int i=0; i<tuples.length; i++) {
            new_tuples[i] = tuples[i];
        }
        tuples = new_tuples;
    }
    
    public void add(int id, String name) {
        try{
            tuples[next_id] = new Tuple(id, name);
            next_id++;
        } catch (IndexOutOfBoundsException e) {
            doubleCapacity();
            add(id, name);
        }
    }
    
    public int size() {
        return next_id;
    }
    
    public Tuple getTuple(int i) {
        return tuples[i];
    }
    
    public Iterator getIterator() {
        return new Iterator(this);
    }
    
    public boolean isNewID(int id) {
        for(Iterator itr = getIterator(); itr.hasNext();) {
            if (itr.next().getID() == id)
                return false;
        }
        return true;
    }
}


class Iterator {
    private Employees emp_data;
    private int next_id = 0;
    
    public Iterator(Employees emp_data) {
        this.emp_data = emp_data;
    }
    
    public boolean hasNext() {
        return next_id < emp_data.size();
    }
    
    public Employees.Tuple next() {
        Employees.Tuple next = emp_data.getTuple(next_id);
        next_id++;
        return next;
    }
}