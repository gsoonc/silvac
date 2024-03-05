package com.gdsc.silvac.backend.services.exception;

public class ClienteNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ClienteNotFound () {
        this.message = "User not found";
    }
    
    public ClienteNotFound(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message; 
    }
    
    private String message;
}
