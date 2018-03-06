package com.zavgorodniy.footballinfo.model;

import com.zavgorodniy.footballinfo.model.response.Response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Competitions extends Response implements Serializable{

    private String id;

    private String name;

    private String text;

    private String time;
}
