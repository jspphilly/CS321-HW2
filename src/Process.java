
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhillyFam
 */
public class Process implements Comparable<Process>{

    private int priority;
    private int timeRemaining;
    private final Date arrival;
    
    
    public Process(int priority, int timeRemaining){
        this.priority = priority;
        this.timeRemaining = timeRemaining;
        this.arrival = new java.util.Date();
    }

   
    void reduceTimeRemaining() {
        timeRemaining--;
    }
    
    void incrementPriority(){
        priority++;
    }

    boolean finish() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void resetTimeNotProcessed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Date getArrivalTime() {
       return arrival;
    }

    int getTimeRemaining() {
        return timeRemaining;
    }
    
    int getPriority() {
        return priority;
    }
    

       
    @Override
    public int compareTo(Process t) {
      if(getPriority() > t.getPriority()){
            return 1;
        }
        else if(getPriority() < t.getPriority()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
