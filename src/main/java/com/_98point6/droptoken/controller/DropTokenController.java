package com._98point6.droptoken.controller;

import com._98point6.droptoken.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/drop_token/")
@Slf4j
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

    @GetMapping("/{id}")
    public ResponseEntity<GameStatusResponse> getGameStatus(@PathVariable("id") String gameId) {
        log.info("gameId = {}", gameId);
        return new ResponseEntity(new GameStatusResponse.Builder().state("in progress")
                .players(new ArrayList<>())
                .moves(2).build(), HttpStatus.OK);
    }

    @PostMapping("/{id}/{playerId}")
    public ResponseEntity<PostMoveResponse> postMove(@PathVariable("id") String gameId, @PathVariable("playerId") String playerId,
                                                     @RequestBody PostMoveRequest request) {
        log.info("gameId={}, playerId={}, move={}", gameId, playerId, request);
        return new ResponseEntity(new PostMoveResponse(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{playerId}")
    public ResponseEntity<String> playerQuit(@PathVariable("id") String gameId, @PathVariable("playerId") String playerId) {
        log.info("gameId={}, playerId={}", gameId, playerId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{id}/moves")
    public ResponseEntity<GetMovesResponse> getMoves(@PathVariable("id") String gameId,
                                                     @RequestParam("start") Integer start,
                                                     @RequestParam("until") Integer until) {
        log.info("gameId={}, start={}, until={}", gameId, start, until);
        return new ResponseEntity(new GetMovesResponse(), HttpStatus.OK);
    }

    @GetMapping("/{id}/moves/{moveId}")
    public ResponseEntity<GetMoveResponse> getMove(@PathVariable("id") String gameId, @PathVariable("moveId") Integer moveId) {
        log.info("gameId={}, moveId={}", gameId, moveId);
        return new ResponseEntity(new GetMoveResponse(), HttpStatus.OK);
    }
}
