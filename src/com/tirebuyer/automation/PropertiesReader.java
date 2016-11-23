package com.tirebuyer.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by divi on 8/12/2016.
 */
public class PropertiesReader {

    Properties prop = new Properties();
    InputStream input = null;
    String value = "";

    public String getProperty(String key) {
        try {

            input = new FileInputStream("src/test.properties");
            prop.load(input);
            value = prop.getProperty(key);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

}
