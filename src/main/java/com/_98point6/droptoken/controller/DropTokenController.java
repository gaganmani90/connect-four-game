package com._98point6.droptoken.controller;

import com._98point6.droptoken.model.CreateGameRequest;
import com._98point6.droptoken.model.CreateGameResponse;
import com._98point6.droptoken.model.GetGamesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/drop_token/")
public class DropTokenController {

    @GetMapping
    public ResponseEntity<GetGamesResponse> getGames() {
        return new ResponseEntity<>(new GetGamesResponse(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createGame(@RequestBody CreateGameRequest request) {
        if (request.getPlayers() == null || request.getPlayers().size() != 2) {
            return new ResponseEntity<>("Only 2 players can participate", HttpStatus.BAD_REQUEST);
        }
        String gameId = UUID.randomUUID().toString();
        CreateGameResponse response = new CreateGameResponse.Builder().gameId(gameId).build();
        return new ResponseEntity<>(response.toString(),
                HttpStatus.CREATED);
    }
}
