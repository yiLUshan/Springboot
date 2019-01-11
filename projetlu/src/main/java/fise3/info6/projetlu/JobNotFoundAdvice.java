package fise3.info6.projetlu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fise3.info6.projetlu.model.JobNotFoundException;

@ControllerAdvice
public class JobNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(JobNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String jobNotFoundHandler(JobNotFoundException ex){
		return ex.getMessage();
	}
}
