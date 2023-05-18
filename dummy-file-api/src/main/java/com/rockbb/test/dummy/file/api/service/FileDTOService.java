package com.rockbb.test.dummy.file.api.service;

import com.rockbb.test.dummy.file.api.dto.FileConstant;
import com.rockbb.test.dummy.file.api.dto.FileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = FileConstant.SERVICE_NAME, contextId = "fileDTOService", path = "/fileDTOService")
public interface FileDTOService {

    @GetMapping("/get")
    FileDTO get(@RequestParam("id") long id);

    @PostMapping("/add")
    int add(@RequestBody FileDTO dto);
}
