package com.rockbb.test.dummy.common.impl.service;


import com.rockbb.test.dummy.common.api.service.MiscService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiscServiceImpl implements MiscService {

    @Override
    public String health() {
        return "SUCCESS";
    }
}
