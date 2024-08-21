package com.yomahub.liteflow.test.builder;

import com.yomahub.liteflow.builder.el.LiteFlowChainELBuilder;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit5Extension;

//基于builder模式的单元测试
//这里测试的是通过spring去扫描，但是通过代码去构建chain的用例
@ExtendWith(SolonJUnit5Extension.class)
public class BuilderELSpringbootTest2 extends BaseTest {

	@Inject
	private FlowExecutor flowExecutor;

	// 通过spring去扫描组件，通过代码去构建chain
	@Test
	public void testBuilder() throws Exception {
		LiteFlowChainELBuilder.createChain().setChainName("chain1").setEL("THEN(h, i, j)").build();

		LiteflowResponse response = flowExecutor.execute2Resp("chain1");
		Assertions.assertTrue(response.isSuccess());
		Assertions.assertEquals("h==>i==>j", response.getExecuteStepStr());
	}

}
