package com.mindtree.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
Properties pro;
	
	public PropertyFile() {
		File src=new File("./Configurations/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	

}
