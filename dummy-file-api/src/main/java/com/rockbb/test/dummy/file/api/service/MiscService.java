package com.rockbb.test.dummy.file.api.service;

import com.rockbb.test.dummy.file.api.dto.FileConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * contextId will become the spring bean name in consumer context. If there are same-name services in
 * different modules, add application name as prefix to avoid conflicts.
 */
@FeignClient(name = FileConstant.SERVICE_NAME, contextId = FileConstant.SERVICE_NAME + "-miscService")
public interface MiscService {

    @GetMapping("/health")
    String health();
}
