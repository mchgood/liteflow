package com.yomahub.liteflow.test.builder.vo;

import java.util.Date;

/**
 * EL表达式装配并执行测试
 *
 * @author gezuao
 * @since 2.11.1
 */
public class User {

	private String name;

	private int age;

	private Date birth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
