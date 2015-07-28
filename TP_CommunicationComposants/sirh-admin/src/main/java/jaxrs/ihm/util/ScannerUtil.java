package jaxrs.ihm.util;

import java.util.Scanner;

public class ScannerUtil {
	
	private Scanner scanner = new Scanner(System.in);
	
	private ScannerUtil(){}
	
	private static ScannerUtil instance = new ScannerUtil();
	
	public static ScannerUtil getInstance() {
		return instance;
	}
	
	public void close() {
		scanner.close();
	}
	
	public Integer askUserInt(String message) {
		System.out.println(message);
		return scanner.nextInt();
	}

}
