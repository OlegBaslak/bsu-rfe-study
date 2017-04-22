import ConfigParser.Config;
import ConfigParser.ConfigReader;
import ConfigParser.Options;

/**
 * Created by Oleg on 04.09.2015.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Config.setDefaultConfig();
        System.out.println(ConfigReader.readParametr(Options.namesAndValues.get(1).getKey()));
    }
}
