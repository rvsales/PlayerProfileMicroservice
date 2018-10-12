package io.core.setting.PlayerProfile;

import io.core.setting.PlayerProfile.ErrorModel;

public class PlayerProfileException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	
	private final ErrorModel error;
	
	public PlayerProfileException(ErrorModel error){
		
		super( error.getCode() + " - " + error.getMessage());
		
		this.error = error;
		
	}
	
	public PlayerProfileException(ErrorModel error, Throwable cause ){
		
		super( error.getCode() + " - " + error.getMessage(), cause);
		
		this.error = error;
		
	}
	
	public ErrorModel getError(){
		
		return error;
		
	}	
	
}
