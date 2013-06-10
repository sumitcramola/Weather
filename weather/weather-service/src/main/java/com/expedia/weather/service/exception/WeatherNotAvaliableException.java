package com.expedia.weather.service.exception;


/**
 * The Class WeatherNotAvaliableException.
 */
public class WeatherNotAvaliableException extends RuntimeException {
	
	/** The message. */
	protected String message;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -983735839332517296L;

	/**
	 * Instantiates a new weather not avaliable exception.
	 *
	 * @param cause the cause
	 */
	public WeatherNotAvaliableException(Throwable cause) {
		super(cause);
	}
	

	/**
	 * Instantiates a new weather not avaliable exception.
	 *
	 * @param msg the msg
	 * @param e the e
	 */
	public WeatherNotAvaliableException(String msg, Throwable e) {
		this.message = msg;
		this.initCause(e);
	}


	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

	
	

}
