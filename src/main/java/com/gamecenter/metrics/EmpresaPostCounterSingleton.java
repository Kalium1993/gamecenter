package com.gamecenter.metrics;

public enum EmpresaPostCounterSingleton {
	INSTANCE;

	private int counter = 0;

	public void inc() {
		this.counter++;
	}

	public int getValor() {
		return this.counter;
	}
}
