package com.droptoken.model;

import com.droptoken.exception.ExceptionMessage;
import com.droptoken.exception.InvalidGameException;
import com.google.common.base.Preconditions;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 *
 */
@Data
public class CreateGameRequest implements Request{
    private List<String> players;
    private Integer columns;
    private Integer rows;

    public CreateGameRequest() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("players", players)
                .append("columns", columns)
                .append("rows", rows)
                .toString();
    }

    @Override
    public boolean validate() throws InvalidGameException {
        if (this.getPlayers() == null || this.getPlayers().size() != 2) {
            throw new InvalidGameException(ExceptionMessage.INVALID_PLAYERS);
        }
        if (columns <= 0 || rows <= 0) {
            throw new InvalidGameException(ExceptionMessage.INVALID_ROW_COLUMN);
        }
        return true;
    }

}
