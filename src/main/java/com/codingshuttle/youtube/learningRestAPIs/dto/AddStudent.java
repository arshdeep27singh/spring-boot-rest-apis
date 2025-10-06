package com.codingshuttle.youtube.learningRestAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudent {
    private String name;
    private String email;
}
