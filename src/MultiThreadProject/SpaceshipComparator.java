/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreadProject;

import java.util.Comparator;

/**
 *
 * @author JGBOESE
 */
public class SpaceshipComparator implements Comparator<Ship>{

    @Override
    public int compare(Ship o1, Ship o2) 
    {
        double elapsedTime1 = o1.finishTime-o1.startTime;
        double elapsedTime2 = o2.finishTime-o2.startTime;
        double delta = elapsedTime1-elapsedTime2;
        if (delta >0) return 1;
        if (delta<0) return -1;
        return 0;
    }
    
}
