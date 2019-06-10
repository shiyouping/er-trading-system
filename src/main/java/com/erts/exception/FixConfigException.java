package com.erts.exception;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since 10 Jun 2019
 */
public class FixConfigException extends ErtsRuntimeException {

	private static final long serialVersionUID = 1L;

	public FixConfigException(String message, Throwable cause) {
		super(message, cause);
	}

	public FixConfigException(String message) {
		super(message);
	}

	public FixConfigException(Throwable cause) {
		super(cause);
	}
}
