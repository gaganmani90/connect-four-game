package com.droptoken.repository;

import com.droptoken.model.GetMoveResponse;
import lombok.Builder;

@Builder
public class Move {
    private String type;
    private String player;
    private int column;
    private int sequence;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        return builder.append("type:"+type+",")
                .append("player:"+player+",")
                .append("column:"+column)
                .toString();
    }

    public GetMoveResponse moveResponse() {
        return GetMoveResponse.builder().column(column)
                .player(player)
                .type(type)
                .build();
    }
}
