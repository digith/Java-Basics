package com.digithkv.java.basics.designpatterns.creational;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class SingletonDesignPattern implements Serializable,Cloneable {
	private static SingletonDesignPattern instance;/*=new SingletonClass(); -- Eager Loading*/
	private SingletonDesignPattern() {
	}
	public static SingletonDesignPattern getInstance() {
		if(instance==null) {
			synchronized (SingletonDesignPattern.class) {
				if(instance==null) {
					instance = new SingletonDesignPattern(); // Lazy Loading
				}
			}
		}
		return instance;
	}

	public Object readResolve(){
		return getInstance();
	}
	
	public Object clone() {
		return getInstance(); // throw CloneNotSupportedException("Singleton Pattern");
	}
	
	public static void main(String[] args) throws Exception {
		SingletonDesignPattern sc1 = getInstance();
		// Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(sc1);
        oos.close();

        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SingletonDesignPattern sc2 = (SingletonDesignPattern) ois.readObject();
        System.out.println(sc1==sc2);
        
        //Clone
        SingletonDesignPattern sc3 =  (SingletonDesignPattern) sc1.clone();
        System.out.println(sc2==sc3);
        
        //Reflection
        Constructor<SingletonDesignPattern> constructor = SingletonDesignPattern.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDesignPattern sc4 = constructor.newInstance();
        System.out.println(sc1 == sc4);
	}
}




enum EnumSingleton {

	INSTANCE;

	public void someMethod(String param) {
		// implementation 
	}
}
