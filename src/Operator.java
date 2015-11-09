/**
 * Created on 10.11.2015.
 */
abstract public class Operator {
    String code;
    public Operator(String code)
    {
        this.code = code;
    }

    abstract public void exec(Interpreter intrpr);
}
