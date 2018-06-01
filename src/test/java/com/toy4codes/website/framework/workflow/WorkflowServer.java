package com.toy4codes.website.framework.workflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.toy4codes.website.framework.utils.StringUtil;

public class WorkflowServer {

	private static final Logger log = Logger.getLogger(WorkflowServer.class);

	private static final String JDBC_URL = "jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000";
	private static final String JDBC_DRIVER = "org.h2.Driver";
	private static final String JDBC_USERNAME = "sa";
	private static final String JDBC_PASSWORD = StringUtil.EMPTY;

	private static final int JDBC_MAX_ACTIVE_CONNECTIONS = 10;
	private static final int JDBC_MAX_IDLE_CONNECTIONS = 4;
	private static final int JDBC_MAX_CHECKOUT_TIME = 20 * 1000;
	private static final int JDBC_MAX_WAIT_TIME = 20 * 1000;

	@Test
	public void bootstrap() {

		ProcessEngineConfiguration cfg = new StandaloneInMemProcessEngineConfiguration().setJdbcUrl(JDBC_URL)
				.setJdbcDriver(JDBC_DRIVER).setJdbcUsername(JDBC_USERNAME).setJdbcPassword(JDBC_PASSWORD)
				.setJdbcMaxActiveConnections(JDBC_MAX_ACTIVE_CONNECTIONS)
				.setJdbcMaxIdleConnections(JDBC_MAX_IDLE_CONNECTIONS).setJdbcMaxCheckoutTime(JDBC_MAX_CHECKOUT_TIME)
				.setJdbcMaxWaitTime(JDBC_MAX_WAIT_TIME)
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);

		ProcessEngine processEngine = cfg.buildProcessEngine();

		String processEngineName = processEngine.getName();
		String processEngineVersion = ProcessEngine.VERSION;

		log.info("ProcessEngine [" + processEngineName + "] Version: [" + processEngineVersion + "]");
		
		processEngine.close();

	}

}
