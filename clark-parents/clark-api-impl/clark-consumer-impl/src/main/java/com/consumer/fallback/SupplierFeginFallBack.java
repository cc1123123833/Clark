package com.consumer.fallback;

import com.common.entity.InputParam;
import com.common.view.ReturnCode;
import com.common.view.ReturnView;
import com.consumer.fegin.SupplierFegin;
import org.springframework.stereotype.Component;

@Component
public class SupplierFeginFallBack implements SupplierFegin {
    @Override
    public ReturnView getClarkConfigName() {
        ReturnView build = ReturnView.builder().code(ReturnCode.FAIL.val()).message(ReturnCode.FAIL.msg()).build();
        return build;
    }

    @Override
    public ReturnView helloWorld(InputParam param) {
        ReturnView build = ReturnView.builder().code(ReturnCode.FAIL.val()).message(ReturnCode.FAIL.msg()).build();
        return build;
    }
}
