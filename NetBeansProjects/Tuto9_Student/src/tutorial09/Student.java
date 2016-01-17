/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial09;

/**
 *
 * @author qingqingzheng
 */
public class Student {
    private String name;
    public Student(String s){
        this.name = s;
    }
    @Override
    public String toString(){
        return "Student name: "+ this.name;
    }
    public boolean isPalindrome(){
        for(int i=0;i<this.name.length()/2;i++){
            int lPos = i;
            int rPos = (this.name.length()-1) - i;
            if(this.name.charAt(lPos)!= this.name.charAt(rPos))
                return false;
        }
        return true;
    }
}
