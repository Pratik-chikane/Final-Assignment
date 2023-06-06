package assignment.FinalAssignment.CoreJava;

class A{
	public int a;
	public int b;
	A(int a ,int b){
		this.a=a;
		this.b=b;
	}
}
class B extends A {

	public int c;
	B(int a,int b,int c){
		super(a,b);//invoked parent class (A) constructor using Super()
		this.c=c;
	}
	public void sum() {
		int sum=0;
		sum=a+b+c;
		System.out.println("sum of three no: "+ sum);
	}
	
}
public class Q2 {

	public static void main(String[] args) {
		
		B obj=new B(21,12,67);
		obj.sum();

	}

}