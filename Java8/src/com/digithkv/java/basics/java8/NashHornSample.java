package com.digithkv.java.basics.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashHornSample {
	public static void main(String[] args) throws ScriptException {
		ScriptEngine se =  new ScriptEngineManager() 
                .getEngineByName("Nashorn"); 
		se.eval("print(\"HelloWorld\");");
	}
}
