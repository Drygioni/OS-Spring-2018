/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreadProject;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jgboese
 */
public class Spaceships 
{
    ArrayList<Ship>collection = new ArrayList<>();
    void add(Ship xwing) {collection.add(xwing);}
    Ship get(int index){return collection.get(index);}
    void startRace()
    {
        collection.stream().forEach((xwing) -> {
            xwing.start();
        });
    }
    void waitforend()
   {
       collection.stream().forEach((xwing) -> {
           try
           {
               xwing.join();
           }
           catch (InterruptedException ex)
           {
               Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
           }
        });
   }
    void rank()
    {
             collection.sort((Ship o1, Ship o2) -> {
                 double elapsedTime1 = o1.finishTime-o1.startTime;
                 double elapsedTime2 = o2.finishTime-o2.startTime;
                 double delta = elapsedTime1-elapsedTime2;
                 if (delta >0) return 1;
                 if (delta<0) return -1;
                 return 0;
             });
    }
}


