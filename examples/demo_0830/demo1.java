/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*

  @author rxf090020
 */
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter year: ");
        int year = input.nextInt();
           /*
           if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
               System.out.println("this is a leap year");
           }
*/
        if (year > 0){
            // do something
        }
        else if ( year < 0){
            // do something else
        }
        else {

        }



        int month = 1;
        switch(month) {
            case 1: break;
            case 2: //do sth
                break; //; continue
            case 3:
            default:
        }
    }
}
