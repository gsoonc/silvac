package com.gdsc.silvac.backend.services.exception;

public class ClienteAlreadyExists extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public ClienteAlreadyExists () {
        this.message = "User already exists";
    }
    
    public ClienteAlreadyExists(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message; 
    }
    
    private String message;

}
