package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public  static Properties intializeProperties() throws IOException
	{
		Properties properties=new Properties();
	File file=new File("src\\test\\resources\\configproperties\\config.properties");
	FileInputStream fis=new FileInputStream(file);
	properties.load(fis);
	return properties;
	}
}
