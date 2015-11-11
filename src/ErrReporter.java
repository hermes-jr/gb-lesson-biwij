/**
 * Created on 11.11.2015.
 */
public final class ErrReporter
{
	/* Singleton
	private static ErrReporter ourInstance = new ErrReporter();

	public static ErrReporter getInstance()
	{
		return ourInstance;
	}
	*/

	private ErrReporter()
	{
	}

	public static void println(int line, String error)
	{
		System.err.println("Error: (" + line +"): " + error);
	}
}
