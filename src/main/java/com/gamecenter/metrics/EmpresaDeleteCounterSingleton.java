package com.gamecenter.metrics;

public enum EmpresaDeleteCounterSingleton {
	INSTANCE;

	private int counter = 0;

	public void inc() {
		this.counter++;
	}

	public int getValor() {
		return this.counter;
	}
}
