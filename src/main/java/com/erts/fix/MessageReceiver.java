package com.erts.fix;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

/**
 * @author Ricky Shi
 *
 * @since 6 Jun 2019
 */
public class MessageReceiver extends MessageCracker {

	@Override
	protected void onMessage(Message message, SessionID sessionID)
			throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {

	}
}
