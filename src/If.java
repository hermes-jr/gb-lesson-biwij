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
		Pattern pattern = Pattern.compile("^(.*) THEN (.*)$",  Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(code);
		if(!matcher.find())
		{
			ErrReporter.println(intrpr.getLine(), "bad operator IF: " + code);
		}
		else
		{
			String cond = matcher.group(1);
			String thenOp = matcher.group(2);
			Object res = null;
			try
			{
				res = Expression.eval(intrpr.getVars(), cond);
				if(res instanceof Boolean && res.equals(true))
				{
					//intrpr.parse(thenOp);
					String[] parts = thenOp.split(" ");
					String opName = parts[0];
					// Construct new operator if condition is ok and execute it right away
					Operator op = OperatorFactory.createOperator(opName.toUpperCase(), thenOp.substring(parts[0].length() + 1));
					op.exec(intrpr);
					return;
				}
			}
			catch (ScriptException e)
			{
				e.printStackTrace();
				intrpr.next();
			}
		}
		intrpr.next();
	}
}
