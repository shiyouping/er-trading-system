package com.erts.fix;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.InputStream;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erts.config.AppConfig;
import com.erts.exception.FixConfigException;
import com.google.inject.Inject;

import quickfix.Acceptor;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SLF4JLogFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since 10 Jun 2019
 */
public class FixServerImpl implements FixServer {

	private static final Logger logger = LoggerFactory.getLogger(FixServerImpl.class);
	private final AppConfig config;
	private final FixApplication application;

	private Acceptor acceptor;

	@Inject
	public FixServerImpl(@Nonnull AppConfig config, @Nonnull FixApplication application) {
		checkNotNull(config, "config cannot be null");
		checkNotNull(application, "application cannot be null");

		this.config = config;
		this.application = application;
	}

	@Override
	public void start() {
		try {
			if (acceptor != null) {
				acceptor.start();
				logger.info("FIX Server started");
				return;
			}

			SessionSettings settings = getSessionSettings();
			MessageStoreFactory storeFactory = new FileStoreFactory(settings);
			LogFactory logFactory = new SLF4JLogFactory(settings);
			MessageFactory messageFactory = new DefaultMessageFactory();

			acceptor = new SocketAcceptor(application, storeFactory, settings, logFactory, messageFactory);
			acceptor.start();
			logger.info("FIX Server started");

		} catch (ConfigError e) {
			logger.error("Failed to start FIX Server due to {}", e);
			throw new FixConfigException("Unable to start FIX Server", e);
		}
	}

	@Override
	public void stop() {
		if (acceptor == null) {
			logger.warn("FIX Server hasn't started");
			return;
		}

		acceptor.stop();
	}

	private SessionSettings getSessionSettings() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(config.getFixConfigFile());
		if (inputStream == null) {
			throw new FixConfigException("No FIX configuration file found");
		}

		logger.info("FIX configuration file {} loaded", config.getFixConfigFile());

		try {
			return new SessionSettings(inputStream);
		} catch (ConfigError e) {
			logger.error("Cannot parse FIX configuration.", e);
			throw new FixConfigException("FIX configuration error", e);
		}
	}
}
