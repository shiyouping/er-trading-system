package com.erts.guice;

import com.erts.config.AppConfig;
import com.google.inject.AbstractModule;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AppConfig.class).toInstance(AppConfig.getInstance());
	}
}
