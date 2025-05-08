package ast;

public class PrintVisitor implements FormulaVisitor <Void, Integer>{
    private final StringBuilder result ;

    public PrintVisitor() {
        this.result = new StringBuilder();
    }

    @Override
    public Void visit(Not form, Integer parentPrec){
        int thisPrec = 4;
        result.append("¬");
        if (parentPrec <= thisPrec) {result.append("(");}
        form.operand().accept(this, parentPrec);
        if (parentPrec <= thisPrec) {result.append(")");}

        return null;

    }

    @Override
    public Void visit (Constant form, Integer parentPrec) {
        result.append(form.value());

        return null;
    }

    @Override
    public Void visit (Atomic form, Integer parentPrec) {
        result.append(form.name());

        return null;
    }

    @Override
    public Void visit(BinaryFormula form, Integer parentPrec) {
        int thisPrec = form.operator().getPrecedence();

        if (parentPrec >= thisPrec) {
            result.append("(");
        }

        form.left().accept(this, thisPrec);
        result.append(" ");
        result.append(form.operator());
        result.append(" ");
        form.right().accept(this, thisPrec);

        if (parentPrec >= thisPrec) {
            result.append(")");
        }
        
        return null;
    }


    public String prettyPrinter () { return result . toString (); }
}
