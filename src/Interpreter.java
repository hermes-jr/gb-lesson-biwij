import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 10.11.2015.
 */
public class Interpreter {
    TreeMap<Integer, Operator> code = new TreeMap<Integer, Operator>();
    Map<String, Double> vars = new HashMap<String, Double>();
    Integer curLine;

    public void next() {
    }
    public void goTo(int line) {
        curLine = line;
    }
    public void parse(String line) {
    }

    public Map<String, Double> getVars()
    {
        return vars;
    }

}
