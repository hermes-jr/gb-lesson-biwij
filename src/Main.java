import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created on 10.11.2015.
 */
public class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader fr = new BufferedReader(new FileReader("src./quad.bas"));
		// Scanner scanner = new Scanner(System.in);
		Interpreter interpreter = new Interpreter();
		while (true)
		{
			// System.out.print("biwij> ");
			// String line = scanner.nextLine();
			String line = fr.readLine();
			if(line == null || line.equalsIgnoreCase("QUIT")) break;
			interpreter.parse(line);
		}
	}
}
