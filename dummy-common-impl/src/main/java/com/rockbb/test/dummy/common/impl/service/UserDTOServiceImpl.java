package com.rockbb.test.dummy.common.impl.service;

import com.rockbb.test.dummy.common.api.dto.UserDTO;
import com.rockbb.test.dummy.common.api.service.UserDTOService;
import com.rockbb.test.dummy.common.impl.repository.inf.UserRepo;
import com.rockbb.test.dummy.file.api.dto.FileDTO;
import com.rockbb.test.dummy.file.api.service.FileDTOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("userDTOService")
public class UserDTOServiceImpl implements UserDTOService {

    @Autowired
    private FileDTOService fileDTOService;

    @Override
    public UserDTO get(long id) {
        log.debug("Get user: {}", id);
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName("dummy");
        return user;
    }

    @Override
    public int add(UserDTO dto) {
        log.debug("Add user: {}", dto.getName());
        return 99;
    }

    @Override
    public UserDTO chainGet(long id) {
        log.debug("Chain get: {}", id);
        FileDTO dto = fileDTOService.get(id);
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName(dto.getName());
        return user;
    }

    @Override
    public int chainAdd(UserDTO dto) {
        log.debug("Chain add: {}", dto.getName());
        FileDTO file = new FileDTO();
        file.setName(dto.getName());
        return fileDTOService.add(file);
    }
}
