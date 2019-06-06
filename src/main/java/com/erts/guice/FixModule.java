package com.erts.guice;

import com.erts.fix.FixApp;
import com.google.inject.AbstractModule;

import quickfix.Application;

/**
 * @author Ricky Shi
 *
 * @since 6 Jun 2019
 */
public class FixModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Application.class).to(FixApp.class);
	}
}
