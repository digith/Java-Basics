package com.digithkv.java.basics.designpatterns.structrual;

public class ProxyDesignPattern {
	public static void main(String[] args) {
		Banking atmbankinBanking = new ATM("1234");
	}
}

interface Banking{
	void withdrawMoney(float withdrawMoney);
	void deposit(float depositMoney);
	float checkBalance();
}

class ActualBankAccount implements Banking{
	private float balance;
	public void withdrawMoney(float withdrawMoney) {
		if(checkBalance()>withdrawMoney) {	}
	}
	@Override
	public void deposit(float depositMoney) {
		
	}
	@Override
	public float checkBalance() {
		return 0;
	}
}

class ATM implements Banking {
	private ActualBankAccount actualBankAccount; 
	
	public ATM(String pin) {
		if(isValid(pin)) {
			actualBankAccount = new ActualBankAccount();
		}
	}
	private boolean isValid(String pin) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void withdrawMoney(float withdrawMoney) {
		if(actualBankAccount!=null) {
			actualBankAccount.withdrawMoney(withdrawMoney);
		}
	}

	@Override
	public void deposit(float depositMoney) {
		if(actualBankAccount!=null) {
			
		}
	}

	@Override
	public float checkBalance() {
		return 0;
	}
	
}