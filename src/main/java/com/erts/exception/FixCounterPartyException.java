package com.erts.exception;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class FixCounterPartyException extends Exception {

	private static final long serialVersionUID = 1L;

	public FixCounterPartyException(String message, Throwable cause) {
		super(message, cause);
	}

	public FixCounterPartyException(String message) {
		super(message);
	}

	public FixCounterPartyException(Throwable cause) {
		super(cause);
	}
}
