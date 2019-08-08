package com.supplier.service.impl;

import com.common.entity.InputParam;
import com.common.entity.OutputParam;
import com.common.view.ReturnCode;
import com.common.view.ReturnView;
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
    public ReturnView helloWorld(InputParam param) {
        var clark = OutputParam.builder().age(18).name("clark").build();
        ReturnView build = ReturnView.builder().code(ReturnCode.SUCCESS.val()).message(ReturnCode.SUCCESS.msg()).data(clark).build();
        return build;
    }


    @Override
    @ApiOperation(value="getClarkConfigName", notes="getClarkConfigName")
    public ReturnView getClarkConfigName() {
        ReturnView build = ReturnView.builder().code(ReturnCode.SUCCESS.val()).message(ReturnCode.SUCCESS.msg()).data(clarkConfigName).build();
        return build;
    }
}
