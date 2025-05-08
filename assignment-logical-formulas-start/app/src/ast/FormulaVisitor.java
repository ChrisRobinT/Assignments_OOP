package ast;

public interface FormulaVisitor<Result , Prec > {
    Result visit (Not form, Prec ParentPrec);
    Result visit (BinaryFormula form, Prec ParentPrec);
    Result visit (Constant form, Prec ParentPrec);
    Result visit (Atomic form, Prec ParentPrec);

    Boolean visit(Constant form, int parentPrec);

    Boolean visit(Atomic form, int parentPrec);
}
