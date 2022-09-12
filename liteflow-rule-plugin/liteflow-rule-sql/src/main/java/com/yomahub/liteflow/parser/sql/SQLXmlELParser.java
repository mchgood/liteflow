package com.yomahub.liteflow.parser.sql;

import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.StrUtil;
import com.yomahub.liteflow.parser.el.ClassXmlFlowELParser;
import com.yomahub.liteflow.parser.sql.exception.ELSQLException;
import com.yomahub.liteflow.parser.sql.util.JDBCHelper;
import com.yomahub.liteflow.parser.sql.vo.SQLParserVO;
import com.yomahub.liteflow.property.LiteflowConfig;
import com.yomahub.liteflow.property.LiteflowConfigGetter;
import com.yomahub.liteflow.util.JsonUtil;

import java.util.List;
import java.util.Objects;

/**
 * SQL 解析器实现，只支持 EL 形式的 XML，不支持其他的形式
 *
 * @author tangkc
 * @since 2.8.6
 */
public class SQLXmlELParser extends ClassXmlFlowELParser {

	private static final String ERROR_MSG_PATTERN = "rule-source-ext-data {} is blank";
	private static final String ERROR_COMMON_MSG = "rule-source-ext-data is empty";

	/**
	 * 构造函数
	 */
	public SQLXmlELParser() {
		LiteflowConfig liteflowConfig = LiteflowConfigGetter.get();

		if (StrUtil.isBlank(liteflowConfig.getRuleSourceExtData())) {
			throw new ELSQLException(ERROR_COMMON_MSG);
		}

		try {
			SQLParserVO sqlParserVO = JsonUtil.parseObject(liteflowConfig.getRuleSourceExtData(), SQLParserVO.class);
			if (Objects.isNull(sqlParserVO)) {
				throw new ELSQLException(ERROR_COMMON_MSG);
			}

			// 检查配置文件
			checkParserVO(sqlParserVO);

			// 初始化 JDBCHelper
			JDBCHelper.init(sqlParserVO);

		} catch (ELSQLException elsqlException) {
			throw elsqlException;
		} catch (Exception ex) {
			throw new ELSQLException(ex.getMessage());
		}

	}

	@Override
	public void parseMain(List<String> pathList) throws Exception {
		List<String> elDataList = JDBCHelper.getInstance().getElDataList();
		parse(elDataList);
	}

	@Override
	public String parseCustom() {
		// 这里返回 null 是因为已经重写了 parseMain 方法的逻辑，不会再调用到这里了
		return null;
	}


	/**
	 * 检查配置文件并设置默认值
	 *
	 * @param sqlParserVO sqlParserVO
	 */
	private void checkParserVO(SQLParserVO sqlParserVO) {
		if (StrUtil.isEmpty(sqlParserVO.getUrl())) {
			throw new ELSQLException(StrFormatter.format(ERROR_MSG_PATTERN, "url"));
		}
		if (StrUtil.isEmpty(sqlParserVO.getDriverClassName())) {
			throw new ELSQLException(StrFormatter.format(ERROR_MSG_PATTERN, "driverClassName"));
		}
		if (Objects.isNull(sqlParserVO.getUsername())) {
			throw new ELSQLException(StrFormatter.format(ERROR_MSG_PATTERN, "username"));
		}
		if (Objects.isNull(sqlParserVO.getPassword())) {
			throw new ELSQLException(StrFormatter.format(ERROR_MSG_PATTERN, "password"));
		}
		if (Objects.isNull(sqlParserVO.getElTable())) {
			sqlParserVO.setElTable(new SQLParserVO.ElTable());
		}
	}
}
