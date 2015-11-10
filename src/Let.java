/**
 * Created on 11.11.2015.
 */
public class Let extends Operator
{
	public Let(String code) { super(code); }

	@Override
	public void exec(Interpreter intrpr)
	{
			System.out.println("Let done");
		intrpr.next();
	}
}
