package com.rockbb.test.dummy.file.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileDTO implements Serializable {
    private Long id;
    private String name;
}
