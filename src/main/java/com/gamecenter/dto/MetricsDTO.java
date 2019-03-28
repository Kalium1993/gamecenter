package com.gamecenter.dto;

public class MetricsDTO {
	private Integer counter;
    private String name;

    public MetricsDTO(String name, Integer counter) {
        this.name = name;
        this.counter = counter;
    }

	public String getName() {
		return this.name;
	}

	public Integer getCounter() {
		return this.counter;
	}
}
