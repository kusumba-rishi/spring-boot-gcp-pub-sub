package com.projects147.google_pub_sub.model;

import lombok.Data;

@Data
public class MovieMessagePayload {

    private String name;
    private String releaseYear;

}
