package controller;

import service.EncoderService;

public class EncoderController {

    public static void main(String[] args) {
	EncoderService encoder = new EncoderService();
	
	String encodedText1 = encoder.encode("HELLO WORLD", "B");
	System.out.println(encodedText1);
	
	String decodedText1 = encoder.decode(encodedText1, "B");
	System.out.println(decodedText1);
	
	String encodedText2 = encoder.encode("HELLO WORLD", "F");
	System.out.println(encodedText2);
	
	String decodedText2 = encoder.decode(encodedText2, "F");
	System.out.println(decodedText2);
    }
}