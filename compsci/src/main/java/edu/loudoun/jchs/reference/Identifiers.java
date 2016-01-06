package edu.loudoun.jchs.reference;

//indentifier example
//demonstrates compile errors
public class Identifiers {
	public static void main(String args[]) {
		/*
		 * Un-comment to demonstrate compile errors 
		 * 
		 * int big Num=99; //illegal spaces
		 * 
		 * double 1decimal = 8.25; //illegal begin with digit
		 * 
		 * double void = 657; //illegal reserved word
		 * 
		 * double testing1-2-3 = 123; //illegal hypens
		 * 
		 * String o'reilly = "O\'Reilly"; //illegal single quotes
		 * 
		 * double AT&T = "AT\&T"; //illegal ampersand
		 */
		char littleA = 'a';

		boolean $isPrime = false;

		String _s = "abc";

		long This_is_an_insanely_long_variable_name_that_just_keeps_going_and_going_and_going_and_well_you_get_the_idea_The_line_breaks_arent_really_part_of_the_variable_name_Its_just_that_this_variable_name_is_so_ridiculously_long_that_it_wont_fit_on_the_page_I_cant_imagine_why_you_would_need_such_a_long_variable_name_but_if_you_do_you_can_have_it = 1l;
	    System.out.println(This_is_an_insanely_long_variable_name_that_just_keeps_going_and_going_and_going_and_well_you_get_the_idea_The_line_breaks_arent_really_part_of_the_variable_name_Its_just_that_this_variable_name_is_so_ridiculously_long_that_it_wont_fit_on_the_page_I_cant_imagine_why_you_would_need_such_a_long_variable_name_but_if_you_do_you_can_have_it);
	}

}