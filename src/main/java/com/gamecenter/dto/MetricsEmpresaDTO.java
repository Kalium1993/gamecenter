package com.gamecenter.dto;

public class MetricsEmpresaDTO {
	private Integer getEmpresaCounter;
	private Integer delEmpresaCounter;
	private Integer postEmpresaCounter;

	public Integer getGetEmpresaCounter() {
		return getEmpresaCounter;
	}

	public void setGetEmpresaCounter(Integer getEmpresaCounter) {
		this.getEmpresaCounter = getEmpresaCounter;
	}

	public Integer getDelEmpresaCounter() {
		return delEmpresaCounter;
	}

	public void setDelEmpresaCounter(Integer delEmpresaCounter) {
		this.delEmpresaCounter = delEmpresaCounter;
	}

	public void setPostEmpresaCounter(Integer postEmpresaCounter) {
		this.postEmpresaCounter = postEmpresaCounter;
	}

	public Integer getPostEmpresaCounter() {
		return postEmpresaCounter;
	}
	
}
