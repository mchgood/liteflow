package com.yomahub.liteflow.test.nullParam;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.annotation.Resource;

/**
 * 单元测试:传递null param导致NPE的优化代码
 *
 * @author LeoLee
 * @since 2.6.6
 **/
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/nullParam/application-local.xml")
public class NullParamTest extends BaseTest {

	@Resource
	private FlowExecutor flowExecutor;

	/**
	 * 支持无参的flow执行，以及param 为null时的异常抛出
	 */
	@Test
	public void testNullParam() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1");
		Assertions.assertTrue(response.isSuccess());
	}

}
