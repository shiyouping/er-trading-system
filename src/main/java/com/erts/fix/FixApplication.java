package com.erts.fix;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class FixApplication implements Application {

	private static final Logger logger = LoggerFactory.getLogger(FixApplication.class);

	private final MessageReceiver messageReceiver;

	@Inject
	public FixApplication(@Nonnull MessageReceiver messageReceiver) {
		checkNotNull(messageReceiver, "messageReceiver cannot be null");
		this.messageReceiver = messageReceiver;
	}

	@Override
	public void onCreate(SessionID sessionId) {
		logger.info("A new session is created. Session={}", sessionId);
	}

	@Override
	public void onLogon(SessionID sessionId) {
		logger.info("The counter party logged on. Session={}", sessionId);
	}

	@Override
	public void onLogout(SessionID sessionId) {
		logger.info("The counter party logged out. Session={}", sessionId);
	}

	@Override
	public void toAdmin(Message message, SessionID sessionId) {
		logger.info("An admin message has been sent to the counterparty. Message={}, Session={}", message, sessionId);
	}

	@Override
	public void fromAdmin(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		logger.info("An admin message has been received from the counterparty. Message={}, Session={}", message,
				sessionId);
	}

	@Override
	public void toApp(Message message, SessionID sessionId) throws DoNotSend {
		logger.info("An application message has been sent to the counterparty. Message={}, Session={}", message,
				sessionId);
	}

	@Override
	public void fromApp(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
		messageReceiver.crack(message, sessionId);
	}
}
