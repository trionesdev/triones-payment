package com.trionesdev.payment.wechatpay.v3.operation.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WechatPayCreateTransferRequest implements Serializable {
    @SerializedName(value = "appid")
    private String appId;
    @SerializedName(value = "out_bill_no")
    private String outBillNo;
    @SerializedName(value = "transfer_scene_id")
    private String transferSceneId;
    @SerializedName(value = "openid")
    private String openId;
    @SerializedName(value = "user_name")
    private String userName;
    @SerializedName(value = "transfer_amount")
    private Integer transferAmount;
    @SerializedName(value = "transfer_remark")
    private String transferRemark;
    @SerializedName(value = "notify_url")
    private String notifyUrl;
    @SerializedName(value = "user_recv_perception")
    private String userRecvPerception;
    @SerializedName(value = "transfer_scene_report_infos")
    private List<TransferSceneReportInfo> transferSceneReportInfos;
}
