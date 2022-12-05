package week1.day1;

public class IsPrime {
	public static void main(String[] args)
	{
		int n=8, count=0;
		for (int i=2; i<=n; i++) {
			if (n % i ==0)
			{
				count++;
			}
		}
		if (count==1){
			System.out.println( n + " is a prime number");
		}
		else {
			System.out.println( n + " is not a prime number");
		}
	}

}

