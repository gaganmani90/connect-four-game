package com.droptoken.model;

import lombok.Builder;

@Builder
public class GetMoveResponse {
    private String type;
    private String player;
    private Integer column;
}
