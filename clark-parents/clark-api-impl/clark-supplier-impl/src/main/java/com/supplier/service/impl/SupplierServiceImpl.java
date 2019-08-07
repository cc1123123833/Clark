package com.supplier.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.supplier.entity.InputParam;
import com.supplier.entity.OutParam;
import com.supplier.service.ISupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("supplier测试demo")
public class SupplierServiceImpl implements ISupplierService {

    @Override
    @ApiOperation(value="helloWorld", notes="helloWorld")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "输入参数", required = true, dataType = "InputParam")
    })
    @HystrixCommand(fallbackMethod = "helloWorldFallBack")
    public OutParam helloWorld(InputParam param) {
        var clark = OutParam.builder().age(250).name("clark").build();
        return clark;
    }

    public OutParam helloWorldFallBack(InputParam param)
    {
        OutParam error = OutParam.builder().age(999).name("错误名称").build();
        return error;
    }
}
