package solutionAlgorthim;

public class RecursionIntro {

	public static void main(String[] args){
		int n = 100;
		System.out.println("The " + n + "th Fibonacci is " + fibonacci(n));;
		for(int i = 0; i < 5; i++){
			System.out.println("Hello world! x" + (i+ 1));
		}
		System.out.println("Without using a for loop:");
		forLoop(5, new Action() {
			
			private int value = 0;
			
			public void act() {
				System.out.println("Hello World! x" + (value + 1));
				value++;
			}
		});
		System.out.println(recursiveFactorial(5));
		hanoiSolution(4, "a", "b", "c");
	}

	private static void hanoiSolution(int i, String string, String string2, String string3) {
		
	}

	private static int fibonacci(int n) {
		if(n<=1){
			return 1;
		}
		else{
			int previous = fibonacci(n-1);
			print("Before we find fibonacci " + n + " we need to find fibonacci " + (n-1) + " which is " + previous);
			int beforePrevious = fibonacci(n-2);
			return previous + beforePrevious;
		}
	}

	private static void forLoop(int i, Action action) {
		if( i <= 0){
			//base case
			return;
		}
		else{
			//standard action
			action.act();
			//recursive call
			forLoop(i-1, action);
		}
	}

	public static int recursiveFactorial(int n){
		if(n > 1){
			return n * recursiveFactorial(n-1);
		}
		return 1;
	}

	private static int count = 1;

	public static void print(String s){
		System.out.println("Move #" + count + ":" + s);
		count ++;
	}

}