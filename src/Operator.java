/**
 * Created on 10.11.2015.
 */
abstract public class Operator
{
	String code;

	public Operator(String code)
	{
		this.code = code;
	}

	@Override
	public String toString()
	{
		return getClass().getName() + " " + code;
	}

	abstract public void exec(Interpreter intrpr);
}
