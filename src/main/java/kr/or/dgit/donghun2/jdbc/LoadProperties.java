package kr.or.dgit.donghun2.jdbc;

import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	private Properties properties;
	private String resourcesPath;
	
	public LoadProperties(String resourcesPath){
		this.resourcesPath = resourcesPath;
		properties = new Properties();
		confAsProperties();
	}

	private void confAsProperties() {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try(InputStream is = contextClassLoader.getResourceAsStream(resourcesPath)){
			properties.load(is);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Properties getProperties(){
		return properties;
	}
}
