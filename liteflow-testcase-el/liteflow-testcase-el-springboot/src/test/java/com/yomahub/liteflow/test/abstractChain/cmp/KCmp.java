package com.yomahub.liteflow.test.abstractChain.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("k")
public class KCmp extends NodeComponent {

	@Override
	public void process() {
		System.out.println("KCmp executed!");
	}

}
