/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.nullParam.cmp;

import com.yomahub.liteflow.core.NodeComponent;

public class ACmp extends NodeComponent {

	@Override
	public void process() {
		System.out.println("ACmp executed!");
		System.out.println("get request data:" + this.getRequestData());
		this.getSlot().setInput("BCmp", "param for BCmp");
	}

}
