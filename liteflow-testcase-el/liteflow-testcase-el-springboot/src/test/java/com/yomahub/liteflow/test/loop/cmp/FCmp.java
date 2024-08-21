/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.loop.cmp;

import cn.hutool.core.collection.ListUtil;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("f")
public class FCmp extends NodeComponent {

	@Override
	public void process() {
		int loopIndex = this.getLoopIndex();
		DefaultContext context = this.getFirstContextBean();
		if (context.hasData("test")){
			List<Integer> list = context.getData("test");
			list.add(loopIndex);
		}else{
			List<Integer> list = ListUtil.toList(loopIndex);
			context.setData("test", list);
		}
	}

}
