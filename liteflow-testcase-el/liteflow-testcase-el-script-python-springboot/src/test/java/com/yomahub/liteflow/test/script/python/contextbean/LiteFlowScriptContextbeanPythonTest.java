package com.yomahub.liteflow.test.script.python.contextbean;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import com.yomahub.liteflow.test.script.python.contextbean.bean.CheckContext;
import com.yomahub.liteflow.test.script.python.contextbean.bean.Order2Context;
import com.yomahub.liteflow.test.script.python.contextbean.bean.OrderContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@TestPropertySource(value = "classpath:/contextbean/application.properties")
@SpringBootTest(classes = LiteFlowScriptContextbeanPythonTest.class)
@EnableAutoConfiguration
@ComponentScan({ "com.yomahub.liteflow.test.script.python.contextbean.cmp",
		"com.yomahub.liteflow.test.script.python.contextbean.bean" })
public class LiteFlowScriptContextbeanPythonTest extends BaseTest {

	@Resource
	private FlowExecutor flowExecutor;

	@Test
	public void testContextBean1() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg", OrderContext.class, CheckContext.class,
				Order2Context.class);
		Assertions.assertTrue(response.isSuccess());
		OrderContext orderContext = response.getContextBean(OrderContext.class);
		CheckContext checkContext = response.getContextBean(CheckContext.class);
		Order2Context order2Context = response.getContextBean(Order2Context.class);
		Assertions.assertEquals(30, orderContext.getOrderType());
		Assertions.assertEquals("d", checkContext.getSign());
		Assertions.assertEquals("order2", order2Context.getOrderNo());
	}

	@Test
	public void testContextBean2() throws Exception {
		OrderContext orderContext = new OrderContext();
		orderContext.setOrderNo("order1");
		CheckContext checkContext = new CheckContext();
		checkContext.setSign("sign1");
		Order2Context orderContext2 = new Order2Context();
		orderContext2.setOrderNo("order2");
		LiteflowResponse response = flowExecutor.execute2Resp("chain2", null, orderContext, checkContext,
				orderContext2);
		Assertions.assertTrue(response.isSuccess());

	}

}
