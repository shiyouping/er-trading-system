package com.erts.fix.guice;

import com.erts.fix.FixApplication;
import com.erts.fix.FixServer;
import com.erts.fix.FixServerImpl;
import com.erts.fix.MessageReceiver;
import com.erts.fix.MessageSender;
import com.erts.fix.MessageSenderImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import quickfix.Application;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class FixModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FixServer.class).to(FixServerImpl.class).in(Scopes.SINGLETON);
		bind(Application.class).to(FixApplication.class).in(Scopes.SINGLETON);
		bind(MessageSender.class).to(MessageSenderImpl.class);
		bind(MessageReceiver.class);
	}
}
