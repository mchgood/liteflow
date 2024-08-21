package com.yomahub.liteflow.test.nodeExecutor;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.annotation.Import;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit5Extension;

/**
 * 测试springboot下的组件重试
 *
 * @author Bryan.Zhang
 * @since 2.5.10
 */
@ExtendWith(SolonJUnit5Extension.class)
@Import(profiles="classpath:/nodeExecutor/application.properties")
public class LiteflowNodeExecutorELSpringbootTest extends BaseTest {

	@Inject
	private FlowExecutor flowExecutor;

	// 默认执行器测试
	@Test
	public void testCustomerDefaultNodeExecutor() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
		DefaultContext context = response.getFirstContextBean();
		Assertions.assertTrue(response.isSuccess());
		Assertions.assertEquals(CustomerDefaultNodeExecutor.class, context.getData("customerDefaultNodeExecutor"));
		Assertions.assertEquals("a", response.getExecuteStepStr());
	}

	// 默认执行器测试+全局重试配置测试
	@Test
	public void testDefaultExecutorForRetry() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain2", "arg");
		DefaultContext context = response.getFirstContextBean();
		Assertions.assertTrue(response.isSuccess());
		Assertions.assertEquals(CustomerDefaultNodeExecutor.class, context.getData("customerDefaultNodeExecutor"));
		Assertions.assertEquals("b==>b==>b", response.getExecuteStepStr());
	}

	// 自定义执行器测试
	@Test
	public void testCustomerExecutor() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain3", "arg");
		Assertions.assertTrue(response.isSuccess());
		Assertions.assertEquals("c", response.getExecuteStepStr());
	}

	// 自定义执行器测试+全局重试配置测试
	@Test
	public void testCustomExecutorForRetry() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain4", "arg");
		DefaultContext context = response.getFirstContextBean();
		Assertions.assertFalse(response.isSuccess());
		Assertions.assertEquals(CustomerNodeExecutorAndCustomRetry.class, context.getData("retryLogic"));
		Assertions.assertEquals("d==>d==>d==>d==>d==>d", response.getExecuteStepStr());
	}

}
