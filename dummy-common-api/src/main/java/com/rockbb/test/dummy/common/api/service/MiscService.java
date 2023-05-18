package com.rockbb.test.dummy.common.api.service;

import com.rockbb.test.dummy.common.api.dto.CommonConstant;
import com.rockbb.test.dummy.common.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * contextId will become the spring bean name in consumer context. If there are same-name services in
 * different modules, add application name as prefix to avoid conflicts.
 */
@FeignClient(name = CommonConstant.SERVICE_NAME, contextId = CommonConstant.SERVICE_NAME + "-miscService")
public interface MiscService {

    @GetMapping("/health")
    String health();
}
