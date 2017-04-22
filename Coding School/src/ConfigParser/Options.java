package ConfigParser;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Oleg on 05.09.2015.
 */
public abstract class Options {
    public static String CONFIG_PATH = "config/options.config";

    //коллекция для хранения дефолтных значений
    public static ArrayList<Pair<String, Object>> namesAndValues = new ArrayList<>();

    //заполнение namesAndValues
    public static void setNamesAndValues() {
        namesAndValues.add(new Pair<>("clientOptionsVersion", 0.1));
        namesAndValues.add(new Pair<>("connectToBnet", false));
        namesAndValues.add(new Pair<>("graphicsQuality", 2));
        namesAndValues.add(new Pair<>("hasSeenCinematic", false));
        namesAndValues.add(new Pair<>("music", true));
        namesAndValues.add(new Pair<>("seasonEndThreshold", 1));
        namesAndValues.add(new Pair<>("sound", true));
    }

    private static float clientOptionsVersion;
    private static boolean connectToBnet;
    private static float graphicsQuality;
    private static boolean hasSeenCinematic;
    private static boolean music;
    private static byte seasonEndThreshold;
    private static boolean sound;

    public static void setClientOptionsVersion(float clientOptionsVersion) {
        Options.clientOptionsVersion = clientOptionsVersion;
    }

    public static void setConnectToBnet(boolean connectToBnet) {
        Options.connectToBnet = connectToBnet;
    }

    public static void setGraphicsQuality(float graphicsQuality) {
        Options.graphicsQuality = graphicsQuality;
    }

    public static void setHasSeencinematic(boolean hasSeencinematic) {
        Options.hasSeenCinematic = hasSeencinematic;
    }

    public static void setMusic(boolean music) {
        Options.music = music;
    }

    public static void setSeasonEndThreshold(byte seasonEndThreshold) {
        Options.seasonEndThreshold = seasonEndThreshold;
    }

    public static void setSound(boolean sound) {
        Options.sound = sound;
    }

    public static float getClientOptionsVersion() {
        return clientOptionsVersion;
    }

    public static boolean isConnectToBnet() {
        return connectToBnet;
    }

    public static float getGraphicsQuality() {
        return graphicsQuality;
    }

    public static boolean isHasSeencinematic() {
        return hasSeenCinematic;
    }

    public static boolean isMusic() {
        return music;
    }

    public static byte getSeasonEndThreshold() {
        return seasonEndThreshold;
    }

    public static boolean isSound() {
        return sound;
    }
}
