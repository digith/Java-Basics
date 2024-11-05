package com.digithkv.java.basics.designpatterns.structrual;

public class FacadeDesignPattern {
	public static void main(String[] args) {
		FacadeClass fc = new FacadeClass();
		fc.bigOperation();
		fc.method9();
	}
}



class FacadeClass{
	private SubSystemA a;
	private SubSystemB b;
	private SubSystemC c;
	private SubSystemD d;
	public FacadeClass() {
		a = new SubSystemA();
		b = new SubSystemB();
		c = new SubSystemC();
		d = new SubSystemD();
	}
	public void method9() {
		this.d.method9();
	}
	public void bigOperation() {
		this.a.method1();
		this.a.method2();
		this.c.method7();
		this.d.method9();
	}
}



class SubSystemA{
	public void method1(){
		
	}
	public void method2(){
		
	}
}


class SubSystemB{
	public void method3(){
		
	}
	public void method4(){
		
	}
	public void method5(){
		
	}
}

class SubSystemC{
	public void method6(){
		
	}
	public void method7(){
		
	}
	public void method8(){
		
	}
}

class SubSystemD{
	public void method9(){
		
	}
}