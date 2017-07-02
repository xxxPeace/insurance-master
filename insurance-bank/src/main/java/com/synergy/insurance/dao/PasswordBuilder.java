package com.synergy.insurance.dao;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service("passwordBuilder")
public class PasswordBuilder {
	public static String passwordBuilder(){
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
	}
	
	/*public static void main(String[] args) {
		PasswordBuilder pb =new PasswordBuilder();
		System.out.println(pb.passwordBuilder());
	}*/

}
