package com.gamecenter.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 9056153083782478681L;
	
	public ServiceException(String msg) {
		super(msg);
	}

}
