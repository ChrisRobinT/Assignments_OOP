package ast;

import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean> {
    AND("∧", 3){
        @Override
        public Boolean apply(Boolean left, Boolean right) {
            return left && right;
        }
    },

    OR("∨", 2){
        @Override
        public Boolean apply(Boolean left, Boolean right) {
            return left || right;
        }
    },
    IMPLIES("=>", 1){
        @Override
        public Boolean apply(Boolean left, Boolean right) {
            return !left || right;
        }
    };

    private final String symbol;
    private final int precedence;

    BinOp(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public String toString(){
        return symbol;
    }

    public int getPrecedence() {
        return precedence;
    }
}
