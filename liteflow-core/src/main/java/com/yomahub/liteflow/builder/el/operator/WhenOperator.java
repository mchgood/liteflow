package com.yomahub.liteflow.builder.el.operator;

import com.yomahub.liteflow.builder.el.operator.base.BaseOperator;
import com.yomahub.liteflow.builder.el.operator.base.OperatorHelper;
import com.yomahub.liteflow.flow.element.Executable;
import com.yomahub.liteflow.flow.element.condition.WhenCondition;
import com.yomahub.liteflow.property.LiteflowConfig;
import com.yomahub.liteflow.property.LiteflowConfigGetter;

/**
 * EL规则中的WHEN的操作符
 *
 * @author Bryan.Zhang
 * @since 2.8.0
 */
public class WhenOperator extends BaseOperator<WhenCondition> {

	@Override
	public WhenCondition build(Object[] objects) throws Exception {
		OperatorHelper.checkObjectSizeGtZero(objects);

		WhenCondition whenCondition = new WhenCondition();

		LiteflowConfig liteflowConfig = LiteflowConfigGetter.get();
		for (Object obj : objects) {
			OperatorHelper.checkObjMustBeCommonTypeItem(obj);
			whenCondition.addExecutable(OperatorHelper.convert(obj, Executable.class));
			whenCondition.setThreadExecutorClass(liteflowConfig.getThreadExecutorClass());
		}
		return whenCondition;
	}

}
