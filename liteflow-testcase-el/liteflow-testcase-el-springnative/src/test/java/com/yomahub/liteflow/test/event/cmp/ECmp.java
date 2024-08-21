/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.event.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import org.springframework.stereotype.Component;

@Component("e")
public class ECmp extends NodeComponent {

	@Override
	public void process() throws Exception {
		System.out.println("CCmp executed!");
		throw new NullPointerException();
	}

	@Override
	public void onError(Exception e) throws Exception {
		DefaultContext context = this.getFirstContextBean();
		context.setData("error", "error:" + this.getNodeId());
		throw new IllegalAccessException("错误事件回调本身抛出异常");
	}

}
