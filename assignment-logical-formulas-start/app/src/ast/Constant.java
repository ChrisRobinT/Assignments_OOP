package ast;

public record Constant(boolean value) implements Formula {
    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A parentPrec) {
        return visitor.visit(this, parentPrec);
    }
}