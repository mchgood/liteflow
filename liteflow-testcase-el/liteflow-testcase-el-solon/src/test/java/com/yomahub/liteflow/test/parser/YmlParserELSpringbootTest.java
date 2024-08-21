package com.yomahub.liteflow.test.parser;

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
 * springboot下的yml parser测试用例
 *
 * @author Bryan.Zhang
 * @since 2.5.0
 */
@ExtendWith(SolonJUnit5Extension.class)
@Import(profiles="classpath:/parser/application-yml.properties")
public class YmlParserELSpringbootTest extends BaseTest {

	@Inject
	private FlowExecutor flowExecutor;

	// 测试无springboot场景的yml parser
	@Test
	public void testYmlParser() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain2", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

}
