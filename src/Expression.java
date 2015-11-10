import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

/**
 * Created on 10.11.2015.
 */
public class Expression
{
	public static Object eval(Map<String, Double> vars, String code) throws ScriptException
	{
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		// Pass stored variables to JS engine
		vars.forEach((k, v) -> engine.put(k, v));
		// Evaluate
		Object ret = engine.eval(code);
		// Get them back
		for (String key : vars.keySet())
		{
			vars.put(key, Double.parseDouble(engine.get(key).toString()));
		}
		return ret;
	}
}
