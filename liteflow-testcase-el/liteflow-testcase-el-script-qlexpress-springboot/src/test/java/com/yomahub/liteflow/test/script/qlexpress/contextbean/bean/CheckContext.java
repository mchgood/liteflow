package com.yomahub.liteflow.test.script.qlexpress.contextbean.bean;

import com.yomahub.liteflow.context.ContextBean;

@ContextBean
public class CheckContext {

	private String sign;

	private int randomId;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getRandomId() {
		return randomId;
	}

	public void setRandomId(int randomId) {
		this.randomId = randomId;
	}

}
