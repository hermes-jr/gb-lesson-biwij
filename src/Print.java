/**
 * Created on 10.11.2015.
 */
public class Print extends Operator {
    public Print(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter intrpr) {
        Expression.eval(intrpr.getVars(), code);
        intrpr.next();
    }
}
