package com.trionesdev.payment.wechatpay.v3.operation.enums;

public enum TransferState {
    /**
     * 单据已受理
     */
    ACCEPTED,
    /**
     * 单据处理中，转账结果尚未明确，如一直处于此状态，建议检查账户余额是否足够
     */
    PROCESSING,
    /**
     * 待收款用户确认，可拉起微信收款确认页面进行收款确认
     */
    WAIT_USER_CONFIRM,
    /**
     * 转账中，转账结果尚未明确，可拉起微信收款确认页面再次重试确认收款
     */
    TRANSFERING,
    /**
     * 转账成功
     */
    SUCCESS,
    /**
     * 转账失败
     */
    FAIL,
    /**
     * 转账取消中
     */
    CANCELING,
    /**
     * 转账取消
     */
    CANCELLED
}
