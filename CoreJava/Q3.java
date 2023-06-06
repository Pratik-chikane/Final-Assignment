package assignment.FinalAssignment.CoreJava;

import java.util.Scanner;

class NegativeNumberException extends RuntimeException {
	public NegativeNumberException(String msg) {
		super(msg);
	}
}

public class Q3 {

	public static void validateNumber(int num) {
		if (num < 0) {
			throw new NegativeNumberException("Number should Not be Negative");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any Integer Number: ");
		int num = sc.nextInt();

		try {

			validateNumber(num);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}