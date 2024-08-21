package com.yomahub.liteflow.test.nodeExecutor;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DataBus;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.slot.Slot;
import com.yomahub.liteflow.flow.executor.NodeExecutor;

/**
 * 自定义节点执行器
 */
public class CustomerNodeExecutor extends NodeExecutor {

	@Override
	public void execute(NodeComponent instance) throws Exception {
		DefaultContext context = instance.getFirstContextBean();
		LOG.info("使用customerNodeExecutor进行执行");
		context.setData("customerNodeExecutor", this.getClass());
		super.execute(instance);
	}

}
