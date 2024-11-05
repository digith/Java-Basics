package com.digithkv.java.basics.designpatterns.structrual;

interface Printer {
	void print();
}

class LegacyPrinter {
	public void printDocument() {
		System.out.println("Legacy Printer is printing a document.");
	}
}

class PrinterAdapter implements Printer {
	private LegacyPrinter legacyPrinter;

	public void print() {
		legacyPrinter.printDocument();
	}
}

class Client {
	PrinterAdapter adapter;

	public void printColorCopies() {
		adapter.print();
	}

	Client(PrinterAdapter adapter) {
		this.adapter = adapter;
	}
}

public class AdapterDesignPattern {
	public static void main() {
		Client student = new Client(new PrinterAdapter());
		student.printColorCopies();
	}

}
