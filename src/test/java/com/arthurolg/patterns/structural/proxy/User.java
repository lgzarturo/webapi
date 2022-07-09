package com.arthurolg.patterns.structural.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    public String username;
    public Boolean isAdmin;
}
