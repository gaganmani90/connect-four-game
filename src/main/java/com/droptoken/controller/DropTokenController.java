package com.droptoken.controller;

import com.droptoken.exception.ExceptionMessage;
import com.droptoken.exception.InvalidGameException;
import com.droptoken.exception.InvalidMoveException;
import com.droptoken.model.*;
import com.droptoken.repository.Game;
import com.droptoken.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/drop_token/")
@Slf4j
public class DropTokenController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping
    public ResponseEntity<Object> getGames() {
        return new ResponseEntity<>(gameRepository.getGames(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody CreateGameRequest request) {
        CreateGameResponse response = null;
        try {
            response = gameRepository.createGame(request);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<Object> postMove(@PathVariable("id") String gameId, @PathVariable("playerId") String playerId,
                                                     @RequestBody PostMoveRequest request) {
        log.info("gameId={}, playerId={}, move={}", gameId, playerId, request);
        Game game = gameRepository.getGames().get(gameId);
        if (game == null) {
            return new ResponseEntity<>(ExceptionMessage.INVALID_MOVE, HttpStatus.BAD_REQUEST);
        }
        try {
            request.validate();
            game.createMove(playerId, request.getColumn());
        } catch (InvalidMoveException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new PostMoveResponse(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{playerId}")
    public ResponseEntity<String> playerQuit(@PathVariable("id") String gameId, @PathVariable("playerId") String playerId) {
        log.info("gameId={}, playerId={}", gameId, playerId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
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
        return new ResponseEntity(GetMoveResponse.builder().build(), HttpStatus.OK);
    }
}
