package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVFile<T> {
	private CSVParser<T> parser = null;
	private Scanner scanner = null;
	
	public void open(String filename) throws FileNotFoundException
	{
		scanner = new Scanner(new FileReader(filename));
		scanner.useDelimiter("\n\n*");
	}
	
	public void close() {
		try { scanner.close(); }
		catch (Exception e) { /* */ }
	}
	
	public void setParser(CSVParser<T> parser) {
		this.parser = parser;
	}
	
	public T readObject() {
		if (parser == null || scanner == null)
			return null;
		while (scanner.hasNext()) {
			String data = scanner.next().trim();
			if (!data.startsWith("#"))
				return parser.parseObject(data);
		}
		return null;
	}
}
