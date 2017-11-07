package edu.mum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE, reason = "Unable to upload file.")
public class UnableToUploadFileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6443177177369064281L;
	
	private String message;
	
	public UnableToUploadFileException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
