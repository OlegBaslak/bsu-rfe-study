package ConfigParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Oleg on 06.09.2015.
 */
public abstract class Config {

    private static File congifFile = new File(Options.CONFIG_PATH);


    public static void setDefaultConfig() {
        /*try (PrintWriter writer = new PrintWriter(congifFile.getAbsoluteFile())) {
            Options.setNamesAndValues();
            StringBuilder stringToWrite = new StringBuilder(Options.namesAndValues.get(0).getKey()
                    + "=" + Options.namesAndValues.get(0).getValue() + System.getProperty("line.separator"));
            for (int i = 1; i < Options.namesAndValues.size(); i++) {
                stringToWrite.append(Options.namesAndValues.get(i).getKey());
                stringToWrite.append("=" + Options.namesAndValues.get(i).getValue() + System.getProperty("line.separator"));
            }
            writer.write(stringToWrite.toString());
            System.out.println("Установлены значения по умолчанию");*/

        //Предлагаю такую реализацию try{} (она немного короче)

        try (PrintWriter writer = new PrintWriter(congifFile.getAbsoluteFile())) {
            Options.setNamesAndValues();
            for (int i=0; i< Options.namesAndValues.size(); i++) {
                writer.write(Options.namesAndValues.get(i).getKey()
                        + "=" + Options.namesAndValues.get(i).getValue()
                        + System.getProperty("line.separator"));
            }
            System.out.println("Установлены значения по умолчанию");
        } catch (FileNotFoundException e) {
            System.out.println("Файл конфигурации не найден!");
        }
        catch (Exception e)
        {
            System.out.println("Неизвестная ошибка");
            e.printStackTrace();
        }
    }

    public static File getCongifFile() {
        return congifFile;
    }

    public static void setCongifFile(String fileName) {
        congifFile = new File(fileName);
    }
}

