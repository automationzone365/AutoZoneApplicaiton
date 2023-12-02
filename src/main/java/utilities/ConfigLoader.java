package utilities;


import java.util.Properties;

public class ConfigLoader {
  private final Properties properties;
  private static ConfigLoader configLoader;
  private ConfigLoader(){
     String env=System.getProperty("env","PROD");
     switch (env){
         case "PROD":
             properties= PropertyReader.propertyLoader("src\\test\\resources\\prod_config.properties");
             break;
         case "STAGE":
             properties= PropertyReader.propertyLoader("src\\test\\resources\\stage_config.properties");
             break;
         default:
             throw new IllegalStateException("Invalid env "+env);
     }
  }

  public static ConfigLoader getInstance(){
      return configLoader==null?new ConfigLoader():configLoader;

  }

  public String getURL(){
      String prop=properties.getProperty("baseURL");
      if(prop!=null){
          return prop;
      }
      else
      {
          throw new RuntimeException("Property baseURL is not specified");
      }

  }

    public String getUsername(){
        String prop=properties.getProperty("username");
        if(prop!=null){
            return prop;
        }
        else
        {
            throw new RuntimeException("Property username is not specified");
        }

    }

    public String getPassword(){
        String prop=properties.getProperty("password");
        if(prop!=null){
            return prop;
        }
        else
        {
            throw new RuntimeException("Property password is not specified");
        }

    }
}
