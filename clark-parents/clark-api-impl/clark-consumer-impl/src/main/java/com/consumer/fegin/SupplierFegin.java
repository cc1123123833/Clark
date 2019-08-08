package com.consumer.fegin;

import com.consumer.fallback.SupplierFeginFallBack;
import com.supplier.service.ISupplierService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "clark-supplier",fallback = SupplierFeginFallBack.class)
public interface SupplierFegin extends ISupplierService {
}
