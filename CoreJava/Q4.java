package assignment.FinalAssignment.CoreJava;

import java.util.Scanner;

class InsufficientBalance extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientBalance(String msg) {
		super(msg);
	}
}

interface Bank {
	void withdraw(double balance);

	void deposit(double balance);
}

class Kotak implements Bank {
	private double accountBalance;

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public void withdraw(double balance) {
		if (balance > this.accountBalance) {
			throw new InsufficientBalance("Insufficient balance to withdraw");
		} else {
			this.accountBalance = this.accountBalance - balance;
			System.out.println(balance + "  has been deducted from your account...");
			System.out.println("your updated balance is: " + getAccountBalance());
		}
	}

	@Override
	public void deposit(double balance) {

		this.accountBalance = this.accountBalance + balance;
		System.out.println(balance + " has been deposited");
		System.out.println("your updated balance is: " + getAccountBalance());
	}
}

public class Q4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int balance;
		Kotak kotak = new Kotak();
		kotak.setAccountBalance(56000);
		int choice;

		while (true) {

			System.out.println("1. Account Balance");
			System.out.println("2. Withdraw Money");
			System.out.println("3. Deposit Money");
			System.out.println("4. Exit");
			System.out.println("Enter your choice..");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Your Account Balance is: " + kotak.getAccountBalance());
				break;
			case 2:
				try {
					System.out.println("enter the amount which you want to withdraw: ");
					balance = sc.nextInt();
					kotak.withdraw(balance);

				} catch (InsufficientBalance ex) {
					ex.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 3:
				try {
					System.out.println("enter the amount which you want to deposit: ");
					balance = sc.nextInt();
					kotak.deposit(balance);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 4:
				System.exit(0);

			}
		}

	}

}