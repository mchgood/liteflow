/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.multiContext.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.test.multiContext.CheckContext;
import org.springframework.stereotype.Component;

@Component("e")
public class ECmp extends NodeComponent {

	@Override
	public void process() {
	}

}
