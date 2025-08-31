package com.sidar.demo1.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserSaveRequest {
    @NotNull
    private String name;
    private String email;
    private String phone;
}
