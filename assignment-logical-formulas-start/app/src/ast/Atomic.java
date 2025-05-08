package ast;

public record Atomic(String name) implements Formula {
    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A parentPrec) {
        return visitor.visit(this, parentPrec);
    }
}