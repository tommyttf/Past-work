/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octopustest;

/**
 *
 * @author Administrator
 */
public class OctopusTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Octopus tom = new Octopus("abc");
        //add some transcations
        tom.addValue(50);
        tom.useValue(20.5);
        tom.addValue(500);
        tom.useValue(20.9);
        tom.useValue(20);
        tom.useValue(20);
        tom.useValue(20);
        tom.useValue(20);
        tom.useValue(20);
        tom.useValue(20);
        tom.useValue(25);
        
        System.out.println(tom);
        Octopus backup = tom.copyCard();
        backup.addValue(50);
        System.out.println("=========");
        System.out.println(backup);  //print out the new card information
        System.out.println(tom);     //print out the old card information
    }
    
}
