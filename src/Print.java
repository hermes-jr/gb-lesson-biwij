import javax.script.ScriptException;

/**
 * Created on 10.11.2015.
 */
public class Print extends Operator
{
	public Print(String code)
	{
		super(code);
	}

	@Override
	public void exec(Interpreter intrpr)
	{
		Object res = null;
		intrpr.next();

		/**
		 * If a quoted string supplied, print it with a newline
		 * or without it depending on semi-comma in the end
		 */
		String trimCode = code.trim();
		if(trimCode.startsWith("\"") && trimCode.length() > 11)
		{
			int firstQuot = trimCode.indexOf("\"");
			String quot = trimCode.substring(firstQuot + 1, trimCode.lastIndexOf("\"") - firstQuot);
			if(trimCode.endsWith(";"))
			{
				System.out.print(quot);
			}
			else
			{
				System.out.println(quot);
			}
			return;
		}

		// Finally, it seems like this expression can be evaluated
		try
		{
			res = Expression.eval(intrpr.getVars(), code);
			System.out.println(res.toString());
		}
		catch (ScriptException e)
		{
			System.err.println("Expression can't be evaluated");
			//e.printStackTrace();
		}
	}
}
