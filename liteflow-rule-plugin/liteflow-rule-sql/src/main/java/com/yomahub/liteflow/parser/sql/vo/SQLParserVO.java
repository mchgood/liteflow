package com.yomahub.liteflow.parser.sql.vo;

import com.yomahub.liteflow.util.JsonUtil;

/**
 * 用于解析 RuleSourceExtData 的 VO 类，用于 sql 模式中
 *
 * @author tangkc
 * @since 2.8.6
 */
public class SQLParserVO {

	/**
	 * 连接地址
	 */
	private String url;

	/**
	 * 驱动
	 */
	private String driverClassName;

	/**
	 * 账号名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * EL 表相关配置
	 */
	private ElTable elTable;

	public static class ElTable {
		/**
		 * 表名
		 */
		private String tableName = "el_table";

		/**
		 * el 表达式相关数据
		 */
		private String elDataField = "el_data";

		public String getTableName() {
			return tableName;
		}

		public ElTable setTableName(String tableName) {
			this.tableName = tableName;
			return this;
		}

		public String getElDataField() {
			return elDataField;
		}

		public ElTable setElDataField(String elDataField) {
			this.elDataField = elDataField;
			return this;
		}
	}

	public String getUrl() {
		return url;
	}

	public SQLParserVO setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public SQLParserVO setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public SQLParserVO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public SQLParserVO setPassword(String password) {
		this.password = password;
		return this;
	}

	public ElTable getElTable() {
		return elTable;
	}

	public SQLParserVO setElTable(ElTable elTable) {
		this.elTable = elTable;
		return this;
	}

	public static void main(String[] args) {
		String s = JsonUtil.toJsonString(new SQLParserVO());
		System.out.println(s);
	}
}
