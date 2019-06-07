package com.erts.guice;

import com.erts.fix.FixApp;
import com.google.inject.AbstractModule;

import quickfix.Application;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class FixModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Application.class).to(FixApp.class);
	}
}
