package com.framework1st.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ComPropReadConfig {

	Properties pro = new Properties();

	public ComPropReadConfig() {

		File src = new File("./Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String uname = pro.getProperty("userName");
		return uname;
	}

	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}

	public String getChromeDriverPath() {
		String cdriver = pro.getProperty("chromepath");
		return cdriver;
	}

	public String getIEDriverPath() {
		String iedriver = pro.getProperty("iepath");
		return iedriver;
	}

	public String getFireFoxDriverPath() {
		String fdriver = pro.getProperty("firefoxpath");
		return fdriver;
	}

}
