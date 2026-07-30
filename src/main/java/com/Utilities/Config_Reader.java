package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config_Reader {

	Properties prop;

	public Properties initializenProperties() {

		prop = new Properties();
		File file = new File("./Config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
