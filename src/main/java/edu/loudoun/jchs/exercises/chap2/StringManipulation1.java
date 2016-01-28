package edu.loudoun.jchs.exercises.chap2;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Solution key concepts: 
 * 1) Strings have a rich API built-in
 * 2) Index methods are zero based
 * 3) The String API can be used dynamically (e.g., "My String".length() )
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class StringManipulation1 extends CommandLineRunner {

	public static void main(String[] args) {
		String inString = (args.length>0) ? args[0] : "John Champe High School";
		//indexes are zero based
		printf("Input String [%s]\n",inString);
		printf(".charAt(3) %c\n",inString.charAt(3));
		printf(".length() %d\n",inString.length());
		//append
		inString = inString.concat(" is my school");
		printf(".concat(...) %s\n",inString);
		//prepend
		inString = "Because I live in Loudoun County, ".concat(inString);
		printf(".concat(...) %s\n",inString);
		printf(".length() %d\n",inString.length());
		printf(".substr(23) %s\n",inString.substring(23));
		printf(".concat(23,32) %s\n",inString.substring(23,32));
		printf(".indexOf(\"school\") %s\n",inString.indexOf("school"));
		printf(".indexOf(\"School\") %s\n",inString.indexOf("School"));
		//swap characters
		inString = inString.replace('o','x');
		printf(".replace(\"o\",\"x\") %s\n",inString);
		printf(".toUpperCase() %s\n",inString.toUpperCase());
		printf(".length() %d\n",inString.length());
	}

}
