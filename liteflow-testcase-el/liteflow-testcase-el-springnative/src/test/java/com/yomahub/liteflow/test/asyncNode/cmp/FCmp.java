package com.yomahub.liteflow.test.asyncNode.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("f")
public class FCmp extends NodeComponent {

	@Override
	public void process() throws Exception {
		System.out.println("Fcomp executed!");
	}

}
