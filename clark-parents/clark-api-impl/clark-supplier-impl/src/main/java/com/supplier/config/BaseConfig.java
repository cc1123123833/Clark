package com.supplier.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Data
public class BaseConfig {

    @Value("${clarkConfigName}")
    private String clarkConfigName;
}
