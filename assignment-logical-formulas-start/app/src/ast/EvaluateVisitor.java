package ast;

import java.util.Map;
import java.util.Objects;

import java.util.Map;
import java.util.Objects;

public abstract class EvaluateVisitor implements FormulaVisitor<Boolean, Void> {
    private final Map<String, Boolean> valuation;

    public EvaluateVisitor(Map<String, Boolean> valuation) {
        this.valuation = Objects.requireNonNull(valuation);
    }

    @Override
    public Boolean visit(Not form, Void parentPrec) {
        // Recursively evaluate the operand
        return !form.operand().accept(this, parentPrec);
    }

    @Override
    public Boolean visit(Constant form, Void parentPrec) {
        return form.value();
    }

    @Override
    public Boolean visit(Atomic form, Void parentPrec) {
        return valuation.getOrDefault(form.name(), false);
    }

    @Override
    public Boolean visit(BinaryFormula form, Void parentPrec) {
        boolean leftVal = form.left().accept(this, parentPrec);
        boolean rightVal = form.right().accept(this, parentPrec);

        // Use the BinOp's built-in apply method instead of conditional logic
        return form.operator().apply(leftVal, rightVal);
    }
}

