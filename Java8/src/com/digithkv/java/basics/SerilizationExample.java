package com.digithkv.java.basics;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class SerilizationExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ToBeSerialized tbs = new ToBeSerialized(0, "some", LocalDate.now(), 23.2, "noop");
		System.out.println(tbs);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(tbs);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		ToBeSerialized tbs1=(ToBeSerialized) ois.readObject();
		System.out.println(tbs1);
		
	}
}

class ToBeSerialized implements Serializable{
	private static final long serialVersionUID = 7178476452117106711L;
	private int field1;
	private String field2;
	private LocalDate field3;
	private double field4;
	private transient String field5;
	public ToBeSerialized(int field1, String field2, LocalDate field3, double field4, String field5) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}
	@Override
	public String toString() {
		return "ToBeSerialized [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4=" + field4
				+ ", field5=" + field5 + "]";
	}
}
