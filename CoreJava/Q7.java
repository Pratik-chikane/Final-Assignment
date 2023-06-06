package assignment.FinalAssignment.CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		String string = findNumber();
		System.out.println(string);
	
	}
	
	public static String findNumber() {

        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>(List.of(34,23,23,8,2,3,25,45,33,7,44,6));
        Collections.sort(list);
        System.out.println("Enter the number to find between 1 to 100");
        int nextInt = sc.nextInt();
        
         int result = Collections.binarySearch(list, nextInt);
         if(0<result&&result<list.size()) {
      	   return "index  "+result+" value"+" "+nextInt;
         }
       
       return "Number Not found"; 
		}

}