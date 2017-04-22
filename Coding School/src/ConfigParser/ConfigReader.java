package ConfigParser;

import java.io.*;

/**
 * Created by Oleg on 05.09.2015.
 */
public class ConfigReader extends Config {

    public static void getFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Options.CONFIG_PATH));
            String s;
            while ((s = reader.readLine()) != null) {

            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл конфигурации не найден!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    TODO  readParametr должен искать определенный параметрв файле по @param String parametr
//    TODO  новый метод readAllParametrs должен считывать все параметры
    public static String readParametr(String parametrName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getCongifFile()))){
            String temp;
            String[] splittedTemp;
            while ((temp = reader.readLine()) != null) {
                splittedTemp = temp.split("=");
                if (splittedTemp[0].equals(parametrName)) {
                    return splittedTemp[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл конфигурации не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения!");
        }
        return null;
    }
}
