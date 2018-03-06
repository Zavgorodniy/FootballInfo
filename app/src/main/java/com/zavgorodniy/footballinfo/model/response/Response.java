package com.zavgorodniy.footballinfo.model.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Response {

    @SerializedName("_links")
    LinksResponse links;
}