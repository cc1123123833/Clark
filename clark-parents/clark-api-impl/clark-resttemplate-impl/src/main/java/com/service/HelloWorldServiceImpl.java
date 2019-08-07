package com.service;

import com.common.entity.InputParam;
import com.common.entity.OutputParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Api("RestTemplate测试Demo")
public class HelloWorldServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取注册中心上有所客户端信息类
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/helloWorld")
    @ApiOperation(value="helloWorld", notes="helloWorld")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "输入参数", required = true, dataType = "InputParam")
    })
    public OutputParam helloWorld(@RequestBody InputParam param)
    {
        var url="http://clark-supplier/helloWorld";
        var result = restTemplate.getForObject(url,OutputParam.class,param);
        return result;
    }

    @PostMapping("/singleClient")
    @ApiOperation(value="获取单个服务接口信息", notes="获取单个服务接口信息")
    public List<ServiceInstance> singleClient()
    {
        return discoveryClient.getInstances("clark-supplier");
    }

    @PostMapping("/clients")
    @ApiOperation(value="获取全部服务接口", notes="获取全部服务接口")
    public List<String> clients()
    {
        return discoveryClient.getServices();
    }
}
