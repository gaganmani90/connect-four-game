package com.droptoken.model;

import com.droptoken.exception.ExceptionMessage;
import com.droptoken.exception.InvalidMoveException;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 */
public class PostMoveRequest implements Request {
    private Integer column;

    public PostMoveRequest() {
    }

    private PostMoveRequest(Builder builder) {
        this.column = Preconditions.checkNotNull(builder.column);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("column", column)
                .toString();
    }

    public Integer getColumn() {
        return column;
    }

    @Override
    public boolean validate() throws InvalidMoveException {
        if (this.column <= 0) {
            throw new InvalidMoveException(ExceptionMessage.INVALID_MOVE);
        }
        return true;
    }

    public static class Builder {
        private Integer column;

        public Builder column(Integer column) {
            this.column = column;
            return this;
        }

        public Builder fromPrototype(PostMoveRequest prototype) {
            column = prototype.column;
            return this;
        }

        public PostMoveRequest build() {
            return new PostMoveRequest(this);
        }
    }
}
