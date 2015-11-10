import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Created on 10.11.2015.
 */
public class Interpreter
{
	/**
	 * Interpreter: "I do all the work!"
	 */
	private TreeMap<Integer, Operator> code = new TreeMap<>();
	private Map<String, Double> vars = new HashMap<>();
	private Integer curLine;

	public void next()
	{
		/**
		 * Move to next line in code and process it
		 */
		curLine = code.higherKey(curLine);
	}

	public void goTo(int line)
	{
		/**
		 * GoTo specific line of code
		 */
		curLine = line;
	}

	public void parse(String line)
	{
		/**
		 * Parse the current line of user input
		 * example:
		 * 10 PRINT 1+1
		 * 20 LET x=1
		 * RUN
		 */
		if (line.equalsIgnoreCase("RUN"))
		{
			this.run();
			return;
		}
		if (line.equalsIgnoreCase("LIST"))
		{
			if(code.isEmpty())
			{
				System.out.println("Program is empty");
			}
			for (int iter : code.keySet())
			{
				System.out.println(iter + " " + code.get(iter));
			}
			return;
		}

		try
		{
			// Split current line to parts and create an Operator class instance, passing parameters
			String[] parts = line.split(" ");
			int lineNum = Integer.parseInt(parts[0]);
			String opName = parts[1];

			Operator op = OperatorFactory.createOperator(opName.toUpperCase(), line.substring(parts[0].length() + parts[1].length() + 2));
			code.put(lineNum, op);
		}
		catch (RuntimeException e)
		{
			System.err.println("Unknown operation");
		}

	}

	public Map<String, Double> getVars()
	{
		/**
		 * Getter for Map containing variables
		 */
		return vars;
	}

	public void run()
	{
		/**
		 * Start running program
		 */
		if(code.isEmpty())
		{
			System.err.println("Program is empty");
			return;
		}
		curLine = code.firstKey();

		while (true)
		{
			if (curLine == null) break;
			Operator oper = code.get(curLine);
			oper.exec(this);
		}
	}
}
