package com.common.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ReturnView<T> {

    private String code;

    private String message;

    private T data;
}
