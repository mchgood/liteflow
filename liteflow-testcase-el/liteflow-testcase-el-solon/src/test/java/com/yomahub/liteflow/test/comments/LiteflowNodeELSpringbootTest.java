package com.yomahub.liteflow.test.comments;

import cn.hutool.core.collection.ListUtil;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.annotation.Import;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.SolonJUnit5Extension;

@ExtendWith(SolonJUnit5Extension.class)
@Import(profiles="classpath:/comments/application.properties")
public class LiteflowNodeELSpringbootTest extends BaseTest {

	@Inject
	private FlowExecutor flowExecutor;

	// 测试注释
	@Test
	public void testAsyncFlow1() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "it's a base request");
		Assertions.assertTrue(response.isSuccess());
		Assertions.assertTrue(ListUtil.toList("a==>b==>c==>b", "a==>b==>b==>c").contains(response.getExecuteStepStr()));
	}

}