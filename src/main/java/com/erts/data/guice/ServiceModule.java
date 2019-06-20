package com.erts.data.guice;

import com.erts.data.service.CounterPartyService;
import com.erts.data.service.CounterPartyServiceImpl;
import com.google.inject.AbstractModule;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since 13 Jun 2019
 */
public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CounterPartyService.class).to(CounterPartyServiceImpl.class);
	}
}
