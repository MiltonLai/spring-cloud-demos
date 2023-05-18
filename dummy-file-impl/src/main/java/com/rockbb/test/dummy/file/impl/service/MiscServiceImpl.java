package com.rockbb.test.dummy.file.impl.service;


import com.rockbb.test.dummy.file.api.service.MiscService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiscServiceImpl implements MiscService {

    @Override
    public String health() {
        return "SUCCESS";
    }
}
