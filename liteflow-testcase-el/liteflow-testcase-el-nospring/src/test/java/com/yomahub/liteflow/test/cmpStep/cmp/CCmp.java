/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.cmpStep.cmp;

import com.yomahub.liteflow.core.NodeComponent;

public class CCmp extends NodeComponent {

	@Override
	public void process() throws Exception {
		System.out.println("CCmp executed!");
		Thread.sleep(2000);
		throw new RuntimeException("test error c");
	}

}
