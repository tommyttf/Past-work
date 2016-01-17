/**
 * CSCI1530 Assignment 1 Naughty Window
 * Aim: Get acquaint to the JDK + NetBeans programming environment
 *      Learn the structure and format of a Java program by example
 * 
 * Remark: Type class names, variable names, method names, etc. as is
 *         You should type also all the comment (text in gray)
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
 * Date        : 4/2/2015
 */
package tool;

import javax.swing.JOptionPane;

public class BMI {

    public static void main(String[] args) {
        String answer, weight, height;
        answer = JOptionPane.showInputDialog("What is your name?");
        weight = JOptionPane.showInputDialog("What is your weight in kilogram?");
        height = JOptionPane.showInputDialog("What is your height in meter?");
        
        double w, h, BMI;
        w = Double.parseDouble(weight);
        h = Double.parseDouble(height);
        BMI = w / (h * h);
        JOptionPane.showMessageDialog(null,answer + ",your BMI is" + BMI);
    }
    
}
