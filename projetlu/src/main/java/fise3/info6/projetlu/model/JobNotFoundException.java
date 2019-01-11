package fise3.info6.projetlu.model;

public class JobNotFoundException extends RuntimeException{
	public JobNotFoundException(String jobId) {
		// TODO Auto-generated constructor stub
		super("Could not find job " + jobId);
	}
}
