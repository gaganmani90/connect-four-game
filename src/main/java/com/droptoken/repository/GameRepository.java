package com.droptoken.repository;

import com.droptoken.exception.InvalidGameException;
import com.droptoken.model.CreateGameRequest;
import com.droptoken.model.CreateGameResponse;
import com.droptoken.model.GetGamesResponse;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Getter
@Service
public class GameRepository {
    private Map<String, Game> games;

    public GameRepository() {
        games = new HashMap<>();
    }

    /**
     * creates and stores a new game
     * @param request
     * @return
     * @throws InvalidGameException
     */
    public CreateGameResponse createGame(CreateGameRequest request) throws InvalidGameException {
        request.validate();
        Game game = new Game(request);
        games.put(game.getGameId(), game);
        return new CreateGameResponse.Builder().gameId(game.getGameId()).build();
    }

    /**
     * returns list of in progress games id
     * @return
     */
    public GetGamesResponse getInProgressGames() {
        GetGamesResponse response = new GetGamesResponse();
        for(String gameId : games.keySet()) {
            if (games.get(gameId).isInProgress()) {
                response.addGame(gameId);
            }
        }
        return response;
    }

}
