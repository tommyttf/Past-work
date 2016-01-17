/**
 * CSCI1530 Assignment 6 HSI
 * 
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of University policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 * 
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty/
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   http://www.cse.cuhk.edu.hk/csci1530/ENGG_Discipline.pdf
 * 
 * Student Name: Tsang Ting Fung
 * Student ID  : 1155030464
 * Date        : 17/4/2015
 */

package tool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Hsi {
    public static void main(String[] args) throws Exception {
        try {
            int startDate;
            Scanner userInput = new Scanner(System.in);
            System.out.print("Start Date: ");
            startDate = userInput.nextInt();
        
            String addr;
            addr = "http://www.cse.cuhk.edu.hk/csci1530/assignment/HSI.txt";
            URL link = new URL(addr);

            Scanner dataStream = new Scanner( link.openStream() );
            String line1 = dataStream.nextLine();
            String line2 = dataStream.nextLine();
            int[] day = new int[4000];  //declare & initialize an int array 
            double[] hsi = new double[4000];
            
            int i = 0;
            while( dataStream.hasNextInt() ){   //input data into arrays
                        day [i] = dataStream.nextInt();
                        hsi [i] = dataStream.nextDouble();
                        i++;
            }
            
            int j = 0;
            while(day[j] != startDate){ //find the index of startDate
                j++;
            }
            
            int numberOfRecords = i - j; //calculate the number of records
            
            double temp;
            for(int k = j; k < i - 1; k++){
                for(int l = k + 1; l < i; l++){
                    if( hsi[l] < hsi[k]){
                        temp = hsi[k];
                        hsi[k] = hsi[l];
                        hsi[l] = temp;
                    }
                }
            }
            
            //calculate the average of data
            double sum = 0; //initialize a sum double
            for(int k = j; k < i; k++){
                sum = sum + hsi[k];
            }
            double average = sum / numberOfRecords;
            
            //calculate the median of data
            double median;
            
            if(numberOfRecords % 2 == 0){
                median = (hsi[j + ( numberOfRecords/2 ) - 1] + hsi[j + ( numberOfRecords/2 )])/2;
            }
            else{
                median = hsi[j + ( numberOfRecords/2 )];
            }
            
            System.out.println("HSI from " + day[j] + " to " + day[i-1]);
            System.out.println("Number of records: " + numberOfRecords);
            System.out.println("Max: " + hsi[i-1]);
            System.out.println("Min: " + hsi[j]);
            System.out.println("Average: " + average);
            System.out.println("Median: " + median );   
        }
        catch (FileNotFoundException e){
            System.out.println("File cannot be opened!"); 
        } 
        catch (IOException e) {
            System.out.println("I/O error! Program exit."); 
        }
    }
}
