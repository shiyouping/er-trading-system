package com.erts.fix;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since 10 Jun 2019
 */
public interface FixServer {

	/**
	 * Start FIX server
	 */
	void start();

	/**
	 * Stop FIX server
	 */
	void stop();
}
