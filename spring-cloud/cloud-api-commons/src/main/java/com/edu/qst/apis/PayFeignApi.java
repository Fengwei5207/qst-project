package com.edu.qst.apis;

import com.edu.qst.entities.PayDTO;
import com.edu.qst.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    public ResultData addPay(PayDTO payDTO);

    @GetMapping("/pay/get/{id}")
    public ResultData getOrderById(@PathVariable("id") Integer id);

    @GetMapping("/pay/get/info")
    public String myLoadBalance();
}
