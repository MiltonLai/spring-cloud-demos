package com.rockbb.test.dummy.file.impl.service;

import com.rockbb.test.dummy.file.api.dto.FileDTO;
import com.rockbb.test.dummy.file.api.service.FileDTOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("fileDTOService")
public class FileDTOServiceImpl implements FileDTOService {

    @Override
    public FileDTO get(long id) {
        log.debug("Get file: {}", id);
        FileDTO user = new FileDTO();
        user.setId(id);
        user.setName("dummy-file");
        return user;
    }

    @Override
    public int add(FileDTO dto) {
        log.debug("Add file: {}", dto.getName());
        return 199;
    }
}
