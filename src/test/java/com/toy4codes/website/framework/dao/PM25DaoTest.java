package com.toy4codes.website.framework.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.beans.PM25;
import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class PM25DaoTest extends SpringContainerLayerJUnitSuite {

	private static final Logger log = Logger.getLogger(PM25DaoTest.class);

	@Autowired
	private PM25Dao pm25Dao;

	@Test
	public void loadAllTest(){
		log.debug(pm25Dao.loadAll(PM25.class).size());
	}

}
