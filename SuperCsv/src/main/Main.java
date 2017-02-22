package main;

import service.InsDBMethods;

public class Main {

	public static void main(String[] args) {
		InsDBMethods idm = new InsDBMethods();
		idm.insSystemKanri();
		idm.insOntime();
	}

}
