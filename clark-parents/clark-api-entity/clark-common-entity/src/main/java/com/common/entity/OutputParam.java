package com.common.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class OutputParam implements Serializable {
    private static final long serialVersionUID = -484303341084601543L;
    private String name;
    private Integer age;

    public OutputParam(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
