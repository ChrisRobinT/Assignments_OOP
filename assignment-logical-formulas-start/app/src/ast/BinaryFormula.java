package ast;

public record BinaryFormula(Formula left, Formula right, BinOp operator) implements Formula {

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A parentPrec) {
        return visitor.visit(this, parentPrec);
    }
}