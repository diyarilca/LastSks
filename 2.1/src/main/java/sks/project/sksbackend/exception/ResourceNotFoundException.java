package sks.project.sksbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
//8.olarak exception katmanını oluşturduk hataları yöneticez
	
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
