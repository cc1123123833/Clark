package com.supplier.service;

import com.supplier.entity.InputParam;
import com.supplier.entity.OutParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ISupplierService {

    @PostMapping("/helloWorld")
    OutParam helloWorld(@RequestBody InputParam param);
}
