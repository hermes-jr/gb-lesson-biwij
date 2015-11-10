import javax.script.ScriptException;

/**
 * Created on 11.11.2015.
 */
public class Let extends Operator
{
	public Let(String code) { super(code); }

	@Override
	public void exec(Interpreter intrpr)
	{
		/**
		 * When this method is called, @code contains something like "x=x+1"
		 */
		String[] parts = code.split("=");
		Object res = null;
		try
		{
			res = Expression.eval(intrpr.getVars(), parts[1]);
			intrpr.getVars().put(parts[0], Double.parseDouble(res.toString()));
		}
		catch (ScriptException e)
		{
			e.printStackTrace();
		}
		intrpr.next();
	}
}
