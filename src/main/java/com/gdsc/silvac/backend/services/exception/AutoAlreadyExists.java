package com.gdsc.silvac.backend.services.exception;

public class AutoAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private String message;
	public AutoAlreadyExists () {
    }
    
    public AutoAlreadyExists(String message) {
    	super(message);
        this.message = message;
    }   
}
