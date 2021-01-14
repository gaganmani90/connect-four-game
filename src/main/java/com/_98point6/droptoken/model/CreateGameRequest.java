package com._98point6.droptoken.model;

import com.google.common.base.Preconditions;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 *
 */
@Data
public class CreateGameRequest {
    private List<String> players;
    private Integer columns;
    private Integer rows;

    public CreateGameRequest() {}

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("players", players)
                .append("columns", columns)
                .append("rows", rows)
                .toString();
    }

}
