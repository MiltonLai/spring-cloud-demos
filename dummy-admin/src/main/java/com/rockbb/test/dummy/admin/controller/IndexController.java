package com.rockbb.test.dummy.admin.controller;

import com.rockbb.test.dummy.common.api.dto.CommonConstant;
import com.rockbb.test.dummy.common.api.dto.UserDTO;
import com.rockbb.test.dummy.common.api.service.UserDTOService;
import com.rockbb.test.dummy.file.api.dto.FileConstant;
import com.rockbb.test.dummy.file.api.dto.FileDTO;
import com.rockbb.test.dummy.file.api.service.FileDTOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class IndexController {

    @Autowired
    private UserDTOService userDTOService;
    @Autowired
    private FileDTOService fileDTOService;

    @GetMapping(value = "/user_get")
    public String doGetUser() {
        UserDTO dto = userDTOService.get(100L);
        return dto.getId() + ":" + dto.getName();
    }

    @GetMapping(value = "/user_add")
    public String doAddUser() {
        UserDTO dto = new UserDTO();
        dto.setName("foobar");
        int result = userDTOService.add(dto);
        return String.valueOf(result);
    }

    @GetMapping(value = "/file_get")
    public String doGetFile() {
        FileDTO dto = fileDTOService.get(200L);
        return dto.getId() + ":" + dto.getName();
    }

    @GetMapping(value = "/file_add")
    public String doAddFile() {
        FileDTO dto = new FileDTO();
        dto.setName("dori");
        int result = fileDTOService.add(dto);
        return String.valueOf(result);
    }

    @GetMapping(value = "/chain_get")
    public String doChainGet() {
        UserDTO dto = userDTOService.chainGet(300L);
        return dto.getId() + ":" + dto.getName();
    }

    @GetMapping(value = "/chain_add")
    public String doChainAdd() {
        UserDTO dto = new UserDTO();
        dto.setName("bernard");
        int result = userDTOService.chainAdd(dto);
        return String.valueOf(result);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public String serviceURL() {
        List<ServiceInstance> services = discoveryClient.getInstances(CommonConstant.SERVICE_NAME);
        for (ServiceInstance instance : services) {
            log.info("{}: {}", CommonConstant.SERVICE_NAME, instance.getUri());
        }
        services = discoveryClient.getInstances(FileConstant.SERVICE_NAME);
        for (ServiceInstance instance : services) {
            log.info("{}: {}", FileConstant.SERVICE_NAME, instance.getUri());
        }

        return "SUCCESS";
    }
}
