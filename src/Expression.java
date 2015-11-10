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
		vars.forEach((k, v) -> engine.put(k, v));
		return engine.eval(code);
	}
}
