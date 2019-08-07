package com.consumer.fegin;

import com.supplier.service.ISupplierService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "clark-supplier")
public interface SupplierFegin extends ISupplierService {
}
