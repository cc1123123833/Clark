package com.consumer.service.impl;

import com.common.entity.InputParam;
import com.common.entity.OutputParam;
import com.consumer.fegin.SupplierFegin;
import com.consumer.service.IConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("consumer测试demo")
public class ConsumerServiceImpl implements IConsumerService {

    @Value("${clarkConfigName}")
    private String clarkConfigName;

    @Autowired
    private SupplierFegin supplierFegin;

    @Override
    @ApiOperation(value = "helloWorld",notes = "helloWorld")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "param", value = "输入参数", required = true, dataType = "InputParam")
    )
    @HystrixCommand(fallbackMethod = "helloWorldFallBack")
    public OutputParam helloWorld(InputParam param) {
        return supplierFegin.helloWorld(param);
    }

    public OutputParam helloWorldFallBack(InputParam param) {
        var error = OutputParam.builder().age(250).name("clark-consumer").build();
        return error;
    }

    @Override
    @ApiOperation(value="getClarkConfigName", notes="getClarkConfigName")
    public String getClarkConfigName() {
        return clarkConfigName;
    }
}
