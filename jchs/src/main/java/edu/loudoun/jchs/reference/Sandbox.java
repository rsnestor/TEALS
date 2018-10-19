package edu.loudoun.jchs.reference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.loudoun.jchs.CommandLineScanner;

public class Sandbox extends CommandLineScanner {

	public static void main(String[] args) {

		String word = "foobar";

		Pattern r = Pattern.compile("^([\"']?)([A-Za-z]+)[.!?]?([\"']?)$");
		CharSequence vowels = "AEIOUaeiou";

		while (word.length() > 0) {

			println("Enter a String");
			word = stdin.next();
			Matcher m = r.matcher(word);
			if (m.matches()){
				if (m.group(1).equals(m.group(3))) {
					println("Match => "+m.group(2));
					if (m.group(2).matches("^[Qq][Uu].*$")) println("* Q-word *");
					if (m.group(2).toLowerCase().matches("^[a,e,i,o,u]+.*?")) println("* Vowel Start *");
				}else {
					println("No match (mis-quoted)");
				}
			} else {
				println ("No match");
			}
//			println(m.matches() ? "Match => " + m.group(2) : "No match");
		}
		// Scanner stdin = new Scanner(System.in);
		//
		// int i=10;
		//
		// println(i*=2);
		/*
		 * Rule[] choices = Rule.values(); print("Enter 1 thru 5 "); Rule r =
		 * choices[Integer.parseInt(stdin.next("[1-5]"))-1];
		 * printf("%s(%d)\n",r,r.value); // for (Rule v : Rule.values()) { //
		 * printf("%s %d\n", v, v.value); // } int yr=0; do { print("Year: ");
		 * yr = stdin.nextInt(); printf("%d %d %d\n",yr%4,yr%100,yr%400); }
		 * while (yr>0);
		 */
		// println("<foo>Word Origin</foo>".matches("^.*?Word Origin.+$"));
		/*
		 * String word = stdin.nextLine(); while
		 * (!word.toLowerCase().equals("q")) { try {
		 * 
		 * URL url = new URL("http://dictionary.reference.com/search/" +
		 * URLEncoder.encode(word)); BufferedReader buf = new BufferedReader(new
		 * InputStreamReader(url.openStream())); String line = buf.readLine();
		 * while (line != null) { if (line.matches("^[Word Origin]?$")) {
		 * System.out.println(line); } } } catch (Exception e) {
		 * e.printStackTrace(); } word = stdin.nextLine(); }
		 */
	}

	public enum Rule {

		ROCK(1), PAPER(2), SCISSORS(3), LIZARD(4), SPOCK(5);

		private int value;

		private Rule(int value) {
			this.value = value;
		}

	}

}
