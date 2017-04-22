package ConfigParser;

import java.io.*;

/**
 * Created by Oleg on 05.09.2015.
 */

public class ConfigWriter extends Config {
    public static void getFile() {
        try {
            File configFile = new File(Options.CONFIG_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(Options.CONFIG_PATH));
            String s;
            while ((s = reader.readLine()) != null){

            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл конфигурации не найден!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
