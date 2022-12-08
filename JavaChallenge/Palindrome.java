package daily.challenges;

public class Palindrome {

	public static void main(String[] args) {
		String sentance = " A man, a plan, a canal: Panama";
		String special = sentance.replaceAll("[,:^]*", ""); 
		String lower = special.replaceAll("\\s", "").toLowerCase();

		char[] charArray = lower.toCharArray();
		String reverseString = "";
		for (int i = charArray.length-1; i >= 0; i--) {
			reverseString = reverseString + charArray[i];
		}

		if(lower.equalsIgnoreCase(reverseString)) { 
			System.out.println(reverseString + " - is a palindrome");
		} 
		else {
			System.out.println(reverseString + " - is not a palindrome");
		}
	}

}
