package com.erts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erts.fix.FixServer;
import com.erts.guice.ConfigModule;
import com.erts.guice.FixModule;
import com.google.inject.Guice;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		Guice.createInjector(new ConfigModule(), new FixModule()).getInstance(FixServer.class).start();
		logger.info("****************** ER Trading System Started ******************");
	}
}
