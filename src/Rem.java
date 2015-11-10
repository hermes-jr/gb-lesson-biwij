/**
 * Created on 11.11.2015.
 */
public class Rem extends Operator
{
	public Rem(String code) { super(code); }

	@Override
	public void exec(Interpreter intrpr)
	{
		/**
		 * Does nothing, simple comment
		 */
		intrpr.next();
	}
}
