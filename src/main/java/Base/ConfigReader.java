package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	static{
		try {
			FileInputStream file=new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(file);
		} 
		catch (IOException e) {
			throw new RuntimeException("failed to load data");
	}
		}
	public static String getProperty(String k) {
		return prop.getProperty(k);
	}
}
