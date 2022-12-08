package daily.challenges;

public class WordLength {

	public static void main(String[] args) {
		String s = "fly me   to   the moon";
		String [] split = s.split(" ");
		{
			System.out.println(split[split.length-1].length());
		}
	}
}
