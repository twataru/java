package main;

import service.CreateCsvMethods;

public class Main {

	public static void main(String[] args) {
		CreateCsvMethods ccm = new CreateCsvMethods();
		ccm.insSystemKanri();
		ccm.insOntime();
	}

}
