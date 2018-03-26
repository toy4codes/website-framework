package com.toy4codes.website.framework.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.beans.Bank;
import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class BankDaoTest extends SpringContainerLayerJUnitSuite {

	private static final Logger log = Logger.getLogger(BankDaoTest.class);

	@Autowired
	private BankDao bankDao;

	@Test
	public void loadAllTest() {
		log.debug(bankDao.loadAll(Bank.class).size());
	}

}
