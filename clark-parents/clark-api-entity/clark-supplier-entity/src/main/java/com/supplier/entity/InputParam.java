package com.supplier.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class InputParam {

    private String name;
    private Integer age;
}
