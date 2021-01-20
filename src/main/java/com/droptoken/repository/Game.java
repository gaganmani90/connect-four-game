package com.droptoken.repository;

import com.droptoken.exception.ExceptionMessage;
import com.droptoken.exception.InvalidMoveException;
import com.droptoken.model.CreateGameRequest;
import com.droptoken.model.GameState;
import com.droptoken.model.GetMoveResponse;
import com.droptoken.model.MoveType;
import lombok.Data;

import java.util.*;

/**
 *
 */
@Data
public class Game {
    private List<String> players;
    private LinkedList<Move> moves;
    private String gameId;
    private String state;
    private String winner;
    private int turn = 0;
    private Board board;
    private static final int WINNER_TOKENS = 4;

    public Game(CreateGameRequest request) {
        players = new ArrayList<>(request.getPlayers());
        board = new Board(request.getRows(), request.getColumns());
        gameId = UUID.randomUUID().toString();
        state = GameState.IN_PROGRESS;
    }

    public boolean isInProgress() {
        if (state.equals(GameState.IN_PROGRESS)) {
            return true;
        }
        return false;
    }

    public List<Move> getSelectedMoves(int start, int until) {
        return moves.subList(start, until);
    }

    public GetMoveResponse createMove(String player, int col) throws InvalidMoveException {
        if (!players.get(turn).equals(player)) {
            throw new InvalidMoveException(ExceptionMessage.INVALID_MOVE + ": it is not " + player + " turn.");
        }
        if (col < 0 || col > board.getBoard().length) {
            throw new InvalidMoveException(ExceptionMessage.INVALID_MOVE + ": column value is out of range");
        }
        if (!board.isSpaceLeft(col)) {
            throw new InvalidMoveException(ExceptionMessage.INVALID_MOVE);
        }
        board.moveWhenLegal(col, player);
        changePlayerTurn();
        boolean isWinner = board.checkWinner(player);

        if(isWinner) {
            state = GameState.DONE;
            winner = player;
        }

        //create and add move
        Move move = Move.builder().column(col).sequence(moves.size()+1).type(MoveType.MOVE).build();
        moves.add(move);

        return move.moveResponse();
    }

    public Move getMove(int number) {
        return moves.get(number);
    }

    /**
     * after create move, next player's turn
     */
    private void changePlayerTurn() {
        if (turn == 0) {
            turn = 1;
        } else {
            turn = 0;
        }
    }

}
