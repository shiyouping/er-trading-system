package com.erts.fix;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.MessageCracker;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fix42.NewOrderSingle;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public class MessageReceiver extends MessageCracker {

	protected void onMessage(NewOrderSingle message, SessionID sessionID)
			throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
	}
}
