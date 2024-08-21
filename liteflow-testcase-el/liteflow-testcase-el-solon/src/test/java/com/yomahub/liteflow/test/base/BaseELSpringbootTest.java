package com.yomahub.liteflow.test.base;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.annotation.Import;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit5Extension;

/**
 * springboot环境EL常规的例子测试
 *
 * @author Bryan.Zhang
 */
@ExtendWith(SolonJUnit5Extension.class)
@Import(profiles="classpath:/base/application.properties")
public class BaseELSpringbootTest extends BaseTest {

	@Inject
	private FlowExecutor flowExecutor;

	// 最简单的情况
	@Test
	public void testBase1() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// switch节点最简单的测试用例
	@Test
	public void testBase2() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain2", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// then,when,switch混用的稍微复杂点的用例,switch跳到一个then上
	@Test
	public void testBase3() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain3", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// 一个非常复杂的例子，可以看base目录下的img.png这个图示
	@Test
	public void testBase4() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain4", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// 用变量来声明短流程
	@Test
	public void testBase5() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain5", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

}
