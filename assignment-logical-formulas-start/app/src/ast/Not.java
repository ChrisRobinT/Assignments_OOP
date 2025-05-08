package ast;

public record Not(Formula operand) implements Formula {
    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A parentPrec) {
        return visitor.visit(this, parentPrec);
    }
}