package com.yomahub.liteflow.builder.el.operator;

import com.yomahub.liteflow.common.ChainConstant;

import java.util.concurrent.TimeUnit;

/**
 * EL 规则中的 maxWaitSeconds 的操作符
 *
 * @author DaleLee
 * @since 2.11.0
 */
public class MaxWaitSecondsOperator extends MaxWaitTimeOperator {

    @Override
    TimeUnit getMaxWaitTimeUnit() {
        return TimeUnit.SECONDS;
    }

    @Override
    String operatorName() {
        return ChainConstant.MAX_WAIT_SECONDS;
    }
}
