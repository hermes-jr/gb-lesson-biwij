/**
 * Created on 11.11.2015.
 */
public class GoTo extends Operator
{
	public GoTo(String code) { super(code); }

	@Override
	public void exec(Interpreter intrpr)
	{
		/**
		 * Simple GOTO
		 */
		intrpr.goTo(Integer.parseInt(code.toString()));
	}
}