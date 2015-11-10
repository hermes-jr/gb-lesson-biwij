import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10.11.2015.
 */
public class OperatorFactory
{
	static Map<String, Class> ops = new HashMap<String, Class>();

	static
	{
		ops.put("PRINT", Print.class);
		ops.put("LET", Let.class);
		ops.put("IF", If.class);
		ops.put("REM", Rem.class);
	}

	public static Operator createOperator(String opName, String substring)
	{
		Class opClass = ops.get(opName);
		try
		{
			return (Operator) opClass.getConstructor(String.class).newInstance(substring);
		}
		catch (InstantiationException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
		catch (NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
	}
}
