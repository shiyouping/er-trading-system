package com.erts.guice;

import com.erts.config.AppConfig;
import com.google.inject.AbstractModule;

/**
 * @author Ricky Shi
 *
 * @since 6 Jun 2019
 */
public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AppConfig.class).toInstance(AppConfig.getInstance());
	}
}
