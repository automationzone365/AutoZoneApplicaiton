package utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static Properties  propertyLoader(String filePath)  {
        Properties properties= new Properties();
        BufferedReader reader;
        try{
            reader=new BufferedReader(new FileReader(filePath));
            properties.load(reader);
        }
        catch (FileNotFoundException e){
            System.out.println("Properties file not found at "+filePath);
        }
        catch(IOException e){
            throw new RuntimeException("failed to load property file "+filePath);
        }


        return properties;
    }
}
