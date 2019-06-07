package com.erts.exception;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class InvalidCounterPartyException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCounterPartyException(String message) {
		super(message);
	}
}
