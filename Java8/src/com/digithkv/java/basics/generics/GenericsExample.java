package com.digithkv.java.basics.generics;

import java.util.List;

public class GenericsExample<T extends DummyClass & DummyInterface> {// order matters Classes then Interface
	T t;
}

class AnotherClass{
	public <A,B> void  doSomething(A a, B b){
		
	}
	
	public void wildCardInList(List<?> list) {
		
	}
}