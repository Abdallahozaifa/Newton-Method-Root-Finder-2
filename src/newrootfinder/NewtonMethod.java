/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newrootfinder;

import java.util.ArrayList;
import java.util.function.Function;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static newrootfinder.NewtonsMethodCalculator.*;
/**
 *
 * @author hea113
 */
public class NewtonMethod {
    Double a,b,c,d,e,f;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewtonsMethodCalculator nmc = new NewtonsMethodCalculator();
        nmc.setLocation(870, 90);
        nmc.setVisible(true);     
    }
    /**
     * intializes the numbers the user put into the function
     * @return weather the numbers can be initialized or not
     */
    public boolean initNumbers(){
        try{
            a = Double.parseDouble(inputNumbers[0]);
            b = Double.parseDouble(inputNumbers[1]);
            c = Double.parseDouble(inputNumbers[2]);
            d = Double.parseDouble(inputNumbers[3]); 
            e = Double.parseDouble(inputNumbers[4]); 
            f = Double.parseDouble(inputNumbers[5]);
            return true;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(new JFrame(), "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    /**
     * the function with the constants the user supplies
     * @param x
     * @returns the function result
     */
    public double function(double x){
        return a*Math.pow(x, 9) + b*Math.pow(x, 7) + c*Math.pow(x, 5) + d*Math.pow(x, 3) + e*x + f;
    }
    
    /**
     * the derivative of the function 
     * @param x
     * @returns the derivative of the function result
     */
    public double functionPrime(double x){
        return 9*a*Math.pow(x, 8)+ 7*b*Math.pow(x, 6) + 5*c*Math.pow(x, 4) + 3*d*Math.pow(x, 2) + e;
    }
    
    /**
     * the second derivative of the function
     * @param x
     * @returns the second derivative of the function
     */
    public double functionPrime2(double x){
        return 72*a*Math.pow(x, 7)+ 42*b*Math.pow(x, 5) + 20*c*Math.pow(x, 3) + 6*d*x;
    }
    /**
     * Recursive function that calculates the root using newton's method
     * @param x
     * @param function
     * @param functionPrime
     * @param diff
     * @param iteration 
     */
    
    public static double newtonMethod(double x, Function<Double, Double> function, Function<Double,Double> functionPrime, int iteration){        
        double guess = x;       
        x = guess - (function.apply(guess)/functionPrime.apply(guess)); //newtons method
        System.out.printf("X"+ iteration+ ": %f" + " f(x): %f\n", x, function.apply(guess));
        iteration++;
        // if new solution - old solution is less than 0.0001 then stop
        if (Math.abs(guess - x) < 0.0001){          
            System.out.println("End");
            return x;
        }else{
            return newtonMethod(x,function, functionPrime, iteration);
        }
        
    }

}
