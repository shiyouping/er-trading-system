package com.erts.config;

import com.google.inject.AbstractModule;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		// AppConfig scope is controlled by itself
		bind(AppConfig.class).toInstance(AppConfig.getInstance());
	}
}
