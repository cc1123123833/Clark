package com.common.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class InputParam implements Serializable {
    private static final long serialVersionUID = -1516252732311320851L;
    private String name;
    private Integer age;
}
