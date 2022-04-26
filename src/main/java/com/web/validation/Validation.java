package com.web.validation;



public class Validation {

	

		public static int validName(String name) {
			if (name.isEmpty() || name.isBlank()) {
				System.out.println("Invalid name ");
				return 1;
			}else
			return 0;

		}
		
		public static int validEmail(String email) {
			if(!email.contains("@")|| !email.contains(".")) {
				System.out.println("Invalid email_id");
				return 1;
			}else
			return 0;
			
		}
		public static int validPasswor(String password) {
			if (password.length()<8 || password.length()>16) {
				System.out.println("Invalid password");
				return 1;
			}else
			return 0;
			
		}
		public static int validnumber(String number) {
			int temp = 0;
			if(number.length() !=10 ) {
				System.out.println("Invalid moblie number ");
				temp++;
			}else {
			
			for (int i=0;i<number.length();i++) {
				char letter = number.charAt(i);
				if(!Character.isDigit(letter)) {
					temp ++;
					System.out.println("Invalid number");
					break;
			}
			}
			}
			
			return temp;
			
		}
		public static int validAddress(String address) {
			if(address.isBlank() || address.isEmpty()) {
				System.out.println("Invalid Address");
				return 1;
			}
			return 0;
			
			
		}

		public static int validDob(String dob) {
			// TODO Auto-generated method stub
			return 0;
		}
			}


