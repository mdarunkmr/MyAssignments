package week1.day1;

public class FibbinocciNumbers {

	public static void main(String[] args) {
		int firstNum = 0, secNum =1, fib;
		System.out.println("The Numbers are " + firstNum);
		for (int i=1; i<11; i++) {
			fib=firstNum + secNum;
			System.out.println(fib);
			secNum = firstNum;
			firstNum = fib;
		}
	}
}
