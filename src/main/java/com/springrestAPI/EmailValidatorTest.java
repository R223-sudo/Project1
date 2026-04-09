package com.springrestAPI;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidatorTest {
	public static void main(String[] args) {
		String email1 = "directorvijay@gmail"; // .com नाही
		String email2 = "rohityadav@gmail"; // पूर्ण valid

		// केस 1: (false, true) → allow TLD without dot
		EmailValidator validator1 = EmailValidator.getInstance(false, true);
		System.out.println("Case 1 (false, true):");
		System.out.println(email1 + " → " + validator1.isValid(email1));
		System.out.println(email2 + " → " + validator1.isValid(email2));

		// केस 2: (false, false) → strict, must have .com/.org etc.
		/*
		 * EmailValidator validator2 = EmailValidator.getInstance(false, true);
		 * System.out.println("\nCase 2 (false, false):"); System.out.println(email1 +
		 * " → " + validator2.isValid(email1)); System.out.println(email2 + " → " +
		 * validator2.isValid(email2));
		 */
	}
}