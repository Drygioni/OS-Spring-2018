/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemem;

/**
 *
 * @author Jared Boese
 */
public class TimeMem {
    public static int max = 8192;
    public static double startTime, finishTime;
    public static double[][] rectangle = new double[max][max];
    
    public static void time1(){
        
        startTime= System.currentTimeMillis()*0.001;
        for(int i = 0;i <max;i++)
            for(int j =0; j<max;j++)
                rectangle[i][j] = 10;
        finishTime= System.currentTimeMillis()*0.001;
        System.out.println(finishTime - startTime);
    
    }
    
    public static void time2(){
        startTime= System.currentTimeMillis()*0.001;
        for(int i = 0;i <max;i++)
            for(int j =0; j<max;j++)
                rectangle[j][i] = 10;
        finishTime= System.currentTimeMillis()*0.001;
        System.out.println(finishTime - startTime);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        // TODO code application logic here
        time1();
        time2();
    }
    
}
