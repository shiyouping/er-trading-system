package com.erts.fix;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;

/**
 * @author Ricky Shi
 *
 * @since 6 Jun 2019
 */
public class MessageSender {

	public void sendMessage(@Nonnull SessionID sessionId, @Nonnull Message message) {
		checkNotNull(sessionId, "sessionId cannot be null");
		checkNotNull(message, "message cannot be null");

		Session session = Session.lookupSession(sessionId);
		if (session == null) {
			throw new SessionNotFound(sessionId.toString());
		}

	}
}
