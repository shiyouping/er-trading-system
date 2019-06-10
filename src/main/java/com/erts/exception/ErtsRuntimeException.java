package com.erts.exception;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since 10 Jun 2019
 */
public class ErtsRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErtsRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErtsRuntimeException(String message) {
		super(message);
	}

	public ErtsRuntimeException(Throwable cause) {
		super(cause);
	}
}
