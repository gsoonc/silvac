package com.gdsc.silvac.backend.services.exception;

public class AutoNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private String message;
	
	public AutoNotFound () {
    }
    
    public AutoNotFound(String message) {
        super(message);
    	this.message = message;
    }

}
