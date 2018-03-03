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
 * @author JGBOESE
 */
public class MultiThreadProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        ArrayList<Ship> xwing= new ArrayList<Ship>();
        int n = 100;
        for(int i =0;i<n;i++)
        {
            xwing.add(new Ship(i));
        }
        for (int i=0;i<n;i++)
        {
            xwing.get(i).start();
        }
                for (int i=0;i<n;i++)
        {
            try 
            {
                xwing.get(i).join();
            } catch (InterruptedException ex) 
            {
                Logger.getLogger(MultiThreadProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        xwing.sort(new SpaceshipComparator());
        String color = " ";
        for(int i = 0;i<10;i++)
        {
            Ship b = xwing.get(i);
            if((i%2)==0)color = "Blue";
            else color = "Red";
            System.out.println(" Rank # "+(i+1) + " is the "+color+ " Spaceship # "+ xwing.get(i).id  + " finished in " +(b.finishTime-b.startTime));
                    
            
        }
                
        System.out.println("main Finished");
    }
    
}
