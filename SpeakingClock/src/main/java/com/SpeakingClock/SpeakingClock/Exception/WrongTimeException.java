package com.SpeakingClock.SpeakingClock.Exception;

public class WrongTimeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongTimeException(String errormsg) {
		super(errormsg);
	}
}
