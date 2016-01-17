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
public class Octopus {
    private String id; // Card id
    private double balance = 40; 
    
    /*
    Constructor method
    */
    public Octopus(String id){
        this.id = id;
        this.balance = 50.0; // Default with some balance
    }
    
    /*
    Add value to octopus card
    Assumed value is positive floating point number
    */
    public void addValue(double value){
        this.balance += value;
    }
    
    /*
    Use the card balance
    Assumed value is positive floating point number
    */
    public void useValue(double value){
        if(value > this.balance){
            System.out.println("Transaction aborted for negative balance.");
            return;
        }
        
        this.balance -= value;
    }
    
    @Override
    public String toString(){
        String text = "Card id: "+this.id+"\n";
        text += String.format("Current balance: $%.2f\n", this.balance);
        return text;
    }
    
    /*
    Copy the octopus card
    */
    public Octopus copyCard(){
        Octopus newCard = new Octopus(this.id);
        // Copy balance
        newCard.balance = this.balance;
        
        return newCard;        
    }
    
}
