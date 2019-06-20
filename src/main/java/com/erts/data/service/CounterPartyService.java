package com.erts.data.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.erts.data.entity.CounterParty;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since 13 Jun 2019
 */
public interface CounterPartyService {

	@Nullable
	CounterParty findByCompanyId(@Nonnull String companyId);
}
