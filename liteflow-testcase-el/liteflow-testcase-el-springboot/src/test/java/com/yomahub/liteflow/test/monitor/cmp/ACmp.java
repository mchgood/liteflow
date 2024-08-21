/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.monitor.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("a")
public class ACmp extends NodeComponent {

	@Override
	public void process() {
		try {
			Thread.sleep(new Random().nextInt(2000));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("ACmp executed!");
	}

}
