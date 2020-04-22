package com.komia.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springApplication.xml"}) 
@Rollback(value=false)
@Transactional(transactionManager="transactionManager")
//@ActiveProfiles("dev")
public class TestBase extends AbstractTransactionalJUnit4SpringContextTests{
	
}
