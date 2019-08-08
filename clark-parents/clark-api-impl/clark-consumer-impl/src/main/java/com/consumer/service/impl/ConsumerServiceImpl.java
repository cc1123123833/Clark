package com.consumer.service.impl;

import com.common.entity.InputParam;
import com.common.view.ReturnCode;
import com.common.view.ReturnView;
import com.consumer.fegin.SupplierFegin;
import com.consumer.service.IConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ReturnView helloWorld(InputParam param) {
        ReturnView returnView = supplierFegin.helloWorld(param);
        return returnView;
    }

    @Override
    @ApiOperation(value="getClarkConfigName", notes="getClarkConfigName")
    public ReturnView getClarkConfigName() {
        ReturnView build = ReturnView.builder().code(ReturnCode.SUCCESS.val()).message(ReturnCode.SUCCESS.msg()).data(clarkConfigName).build();
        return build;
    }
}
