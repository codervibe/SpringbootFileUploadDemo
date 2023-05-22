package com.codervibe.springbootfileuploaddemo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String authority;
}
