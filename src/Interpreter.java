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
        curLine = code.higherKey(curLine);
    }
    public void goTo(int line) {
        curLine = line;
    }
    public void parse(String line) {
        String[] parsed = line.split(" ");
    }

    public Map<String, Double> getVars()
    {
        return vars;
    }

    public void run()
    {
        curLine = code.firstKey();
        while(true)
        {
            Operator oper = code.get(curLine);
            oper.exec(this);
            if(curLine == null) break;
        }
    }
}
