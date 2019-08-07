package com.consumer.service;

import com.common.entity.InputParam;
import com.common.entity.OutputParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IConsumerService{

    @GetMapping("/clarkConfigName")
    String getClarkConfigName();

    @PostMapping("/helloWorld")
    OutputParam helloWorld(@RequestBody InputParam param);
}
