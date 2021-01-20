package com.droptoken.model;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 *
 */
public class GetGamesResponse {
    private List<String> games;

    public GetGamesResponse() {}

    public void addGame(String game) {
        games.add(game);
    }

}
