package com.rockbb.test.dummy.common.api.service;

import com.rockbb.test.dummy.common.api.dto.CommonConstant;
import com.rockbb.test.dummy.common.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = CommonConstant.SERVICE_NAME, contextId = "userDTOService", path = "/userDTOService")
public interface UserDTOService {

    @GetMapping("/get")
    UserDTO get(@RequestParam("id") long id);

    @PostMapping("/add")
    int add(@RequestBody UserDTO dto);

    @GetMapping("/chain_get")
    UserDTO chainGet(@RequestParam("id") long id);

    @PostMapping("/chain_add")
    int chainAdd(@RequestBody UserDTO dto);
}
