package com.yomahub.liteflow.test.asyncNode.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.slot.Slot;
import org.springframework.stereotype.Component;

@Component("c")
public class CCmp extends NodeComponent {

	@Override
	public void process() throws Exception {
		DefaultContext context = this.getFirstContextBean();
		synchronized (NodeComponent.class) {
			if (context.hasData("check")) {
				String str = context.getData("check");
				str += this.getNodeId();
				context.setData("check", str);
			}
			else {
				context.setData("check", this.getNodeId());
			}
		}
		System.out.println("Ccomp executed!");
	}

}
