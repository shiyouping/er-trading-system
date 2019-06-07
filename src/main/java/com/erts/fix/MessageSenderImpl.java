package com.erts.fix;

import static com.google.common.base.Preconditions.checkNotNull;

import com.erts.exception.InvalidCounterPartyException;

import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class MessageSenderImpl implements MessageSender {

	@Override
	public void sendMessage(String counterPartyId, Message message) throws InvalidCounterPartyException {
		checkNotNull(counterPartyId, "counterPartyId cannot be null");
		checkNotNull(message, "message cannot be null");

		SessionID sessionId = new SessionID(counterPartyId);
		Session session = Session.lookupSession(sessionId);

		if (session == null) {
			throw new InvalidCounterPartyException(
					String.format("No Session found for counter party ID %s", counterPartyId));
		}
	}
}
