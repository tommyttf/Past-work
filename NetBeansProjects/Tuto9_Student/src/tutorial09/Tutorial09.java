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
public class Tutorial09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char a = 'c';
        boolean b;
        String z = "qwertyui";
        b = ('q'==z.charAt(0));
        Student stu = new Student("alicila");
        System.out.println(stu.toString());
        System.out.println(stu.isPalindrome());
        
        stu = new Student("otto");
        System.out.println(stu);
        System.out.println(stu.isPalindrome());
        System.out.println(a);
        System.out.println(b);
    }
    
}
