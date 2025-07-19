package com.trionesdev.payment.alipay.v3.fund.transfer;

import com.alipay.v3.api.AlipayFundTransUniApi;
import com.alipay.v3.model.AlipayFundTransUniTransferModel;
import com.alipay.v3.model.AlipayFundTransUniTransferResponseModel;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.fund.AlipayFundCommons;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

public class AlipayMerchantTransfer  extends AlipayFundCommons {
    AlipayFundTransUniApi alipayFundTransUniApi = new AlipayFundTransUniApi();

    public AlipayMerchantTransfer(AlipayConfig alipayConfig) {
        super(alipayConfig);
    }

    /**
     * 创建转账
     * <a href="https://opendocs.alipay.com/open-v3/08e7ef12_alipay.fund.trans.uni.transfer?scene=ca56bca529e64125a2786703c6192d41&pathHash=e2c41149">...</a>
     *
     * @param request 包含转账请求参数的模型对象，具体参数详见 {@link AlipayFundTransUniTransferModel}
     * @return 返回转账操作的响应数据，包含交易状态、交易号等信息，具体结构详见 {@link AlipayFundTransUniTransferResponseModel}
     */
    @SneakyThrows
    public AlipayFundTransUniTransferResponseModel createTransfer(AlipayFundTransUniTransferModel request) {
        if (StringUtils.isBlank(request.getProductCode())){
            request.setProductCode("TRANS_ACCOUNT_NO_PWD");
        }
        return alipayFundTransUniApi.transfer(request);
    }
}
