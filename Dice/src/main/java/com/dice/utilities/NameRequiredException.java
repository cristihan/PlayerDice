package com.dice.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="El parámetro introducido no existe.")
public class NameRequiredException extends Exception {


	private static final long serialVersionUID = -7191829263281102200L;

	public NameRequiredException(String msg) {
		super(msg);
	}
	
	public NameRequiredException() {
		super();
	}
}
