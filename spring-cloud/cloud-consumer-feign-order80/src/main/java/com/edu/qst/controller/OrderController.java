package com.edu.qst.controller;

import cn.hutool.core.date.DateUtil;
import com.edu.qst.apis.PayFeignApi;
import com.edu.qst.entities.PayDTO;
import com.edu.qst.resp.ResultData;
import com.edu.qst.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getOrderInfoById(@PathVariable("id") Integer id){
        ResultData resultData = null;
        try {
            log.info(DateUtil.now());
            resultData = payFeignApi.getOrderById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("end-----"+DateUtil.now());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
            return resultData;
//        return payFeignApi.getOrderById(id);
    }

    @GetMapping("/feign/pay/get/info")
    public String myLoadBalance(){
        return payFeignApi.myLoadBalance();
    }

}
