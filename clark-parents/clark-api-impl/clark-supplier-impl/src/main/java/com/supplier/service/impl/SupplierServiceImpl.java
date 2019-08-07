package com.supplier.service.impl;

import com.common.entity.InputParam;
import com.common.entity.OutputParam;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.supplier.service.ISupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("supplier测试demo")
public class SupplierServiceImpl implements ISupplierService {

    @Value("${clarkConfigName}")
    private String clarkConfigName;

    @Override
    @ApiOperation(value="helloWorld", notes="helloWorld")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "输入参数", required = true, dataType = "InputParam")
    })
    @HystrixCommand(fallbackMethod = "helloWorldFallBack")
    public OutputParam helloWorld(InputParam param) {
        var clark = OutputParam.builder().age(18).name("clark").build();
        return clark;
    }

    public OutputParam helloWorldFallBack(InputParam param)
    {
        var error = OutputParam.builder().age(250).name("clark-supplier").build();
        return error;
    }

    @Override
    @ApiOperation(value="getClarkConfigName", notes="getClarkConfigName")
    public String getClarkConfigName() {
        return clarkConfigName;
    }
}
