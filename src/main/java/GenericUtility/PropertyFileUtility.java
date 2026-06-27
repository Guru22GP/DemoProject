package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
    public String toReadDataFromPropFile(String key) throws Throwable
    {

        FileInputStream fis = new FileInputStream("src/main/resources/CommonData.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;

    }
}
