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
        if(line.equalsIgnoreCase("RUN"))
        {
            this.run();
            return;
        }
        if(line.equalsIgnoreCase("LIST"))
        {
            for(int iter:code.keySet()) {
                System.out.println(iter + " " + code.get(iter));
            }
            return;
        }
        String[] parts = line.split(" ");
        int lineNum = Integer.parseInt(parts[0]);
        String opName = parts[1];

        OperatorFactory.createOperator(opName, line.substring(parts[0].length() + parts[1].length() + 2));

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
