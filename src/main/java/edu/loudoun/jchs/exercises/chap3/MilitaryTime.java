/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import java.text.DecimalFormat;

import edu.loudoun.jchs.CommandLineScanner;

/**
 * Convert integer input to military time when format is appropriate
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class MilitaryTime extends CommandLineScanner {
	
	public static final String ILLEGAL = "** Illegal **";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		println("Military time converter.  Enter time (HHMM), -1 to quit.");
		int time = stdin.nextInt();
		while (time != -1) {
			printf("%d -> %s", time, MilitaryTime.parseTime(time));
			time = stdin.nextInt();
		}
	}

	/**
	 * Convert the int parameter into civilian time
	 * Algorithm:<br>
	 * 0 &lt;= hr &lt; 24 <br>
	 * 0 &lt;= min &lt; 60 <p>
	 * Note: Seconds not supported
	 * 
	 * @param time form nnnn
	 * @return
	 */
	public static String parseTime(int time) {
		String sTime = ILLEGAL; // default
		String daytime = "AM"; // default
		DecimalFormat hfmt = new DecimalFormat("#");
		DecimalFormat mfmt = new DecimalFormat("00");
		if (time >= 0 && time < 2400) {
			//divide by 100 to determine hours
			int hr = (time<100)?0:time/100;
			//subtract whole hours to determine remaining minutes
			int min = time - (hr * 100);
			
			//printf("%d %d\n",hr,min);
			if (min < 60) {
				if (hr < 12) {
					daytime = "AM";
					//if midnight (0 hour), replace with 12 for formatting
					if (hr==0) hr+=12;
				} else {
					daytime = "PM";
					//Subtract 12 from total hours for formatting
					hr += (hr>12)?-12:0;
				}
				sTime = hfmt.format(hr) + ":" + mfmt.format(min) + " " + daytime;
			}
		}
		return sTime;
	}

}
