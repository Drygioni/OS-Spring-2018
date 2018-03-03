/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreadProject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JGBOESE
 */
public class Ship extends Thread
{
    int id;
  public  double finishTime, startTime;
    Ship(int _id) 
    {
        id =_id;
    }
    @Override
    public void run()
    {
       startTime= System.currentTimeMillis()*0.001;
        try 
        {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
        }
        finishTime= System.currentTimeMillis()*0.001;
    }
}
