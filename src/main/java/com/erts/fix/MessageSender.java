package com.erts.fix;

import javax.annotation.Nonnull;

import com.erts.exception.InvalidCounterPartyException;

import quickfix.Message;
import quickfix.SessionID;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
public interface MessageSender {

	/**
	 * 
	 * Send a FIX message to the given counter party
	 * 
	 * @param counterPartyId A String representative of {@link SessionID}
	 * @param message        A FIX message
	 * @throws InvalidCounterPartyException Cannot find a counter party associated
	 *                                      with the given counterPartyId
	 */
	void sendMessage(@Nonnull String counterPartyId, @Nonnull Message message) throws InvalidCounterPartyException;
}
