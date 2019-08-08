package com.consumer.service;

import com.common.entity.InputParam;
import com.common.entity.OutputParam;
import com.common.view.ReturnView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IConsumerService{

    @GetMapping("/clarkConfigName")
    ReturnView getClarkConfigName();

    @PostMapping("/helloWorld")
    ReturnView helloWorld(@RequestBody InputParam param);
}
