package com.yomahub.liteflow.test.parallelLoop.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.core.NodeBooleanComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.enums.NodeTypeEnum;
import com.yomahub.liteflow.slot.DefaultContext;
import org.springframework.stereotype.Component;

@Component("z")
public class ZCmp extends NodeBooleanComponent {

    @Override
    public boolean processBoolean() throws Exception {
        DefaultContext context = this.getFirstContextBean();
        String key = "test";
        if (context.hasData(key)) {
            int count = context.getData("test");
            return count < 5;
        } else {
            return true;
        }
    }
}
