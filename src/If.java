import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 11.11.2015.
 */
public class If extends Operator
{
	public If(String code) { super(code); }

	@Override
	public void exec(Interpreter intrpr)
	{
		/**
		 * When this method is called, @code contains something like "x<10 THEN GOTO 10"
		 */
		Pattern pattern = Pattern.compile("^(.*) THEN GOTO (\\d+)$",  Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(code);
		intrpr.next();
		if(!matcher.find())
		{
			System.err.println("Bad operator IF");
		}
		else
		{
			String cond = matcher.group(1);
			int targLine = Integer.parseInt(matcher.group(2));
			Object res = null;
			try
			{
				res = Expression.eval(intrpr.getVars(), cond);
				if(res instanceof Boolean && res.equals(true))
				{
					intrpr.goTo(targLine);
				}
			}
			catch (ScriptException e)
			{
				e.printStackTrace();
			}
		}
	}
}
