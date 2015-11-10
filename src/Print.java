import javax.script.ScriptException;

/**
 * Created on 10.11.2015.
 */
public class Print extends Operator {
    public Print(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter intrpr) {
        Object res = null;
        try {
            res = Expression.eval(intrpr.getVars(), code);
            System.out.println(res.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        intrpr.next();
    }
}
