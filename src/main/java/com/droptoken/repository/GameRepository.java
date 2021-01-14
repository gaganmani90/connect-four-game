package com.droptoken.repository;

import com.droptoken.exception.InvalidGameException;
import com.droptoken.model.CreateGameRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameRepository {
    Map<String, CreateGameRequest> games = new HashMap<>();


    public String createGame(CreateGameRequest request) throws InvalidGameException {
        if(request.getPlayers() == null || request.getPlayers().size() != 2) {
            throw new InvalidGameException();
        }
        String gameId = UUID.randomUUID().toString();
        games.put(gameId, request);

        return gameId;
    }

}
