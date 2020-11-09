package com.kinsec.test;

import java.io.File;

public class FileUtils {

    public static String getPrefix(String fileName) {
        if (fileName.contains(".")) {
        	fileName = fileName.substring(0,fileName.lastIndexOf("."));
        }
        return fileName;
    }
    
    
    public static String getFileName(String poth) {
        File tempFile =new File( poth.trim());  
        String fileName = tempFile.getName();  
        System.out.println("fileName = " + fileName); 
        return fileName;
	}
}
