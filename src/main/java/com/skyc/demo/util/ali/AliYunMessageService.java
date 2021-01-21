package com.skyc.demo.util.ali;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;

@Service
public interface AliYunMessageService {

    public SendSmsResponse sendSms(String phoneNumber, String code);

    public QuerySendDetailsResponse querySendDetails(String bizId, String phoneNumber) throws ClientException;
}
