package capgemini.academy.bootcamp;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFunctions {
    //Random functions only available within package
    public static float RandomRangeFloat(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }
    public static int RandomRangeInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /*
    public static boolean SearchString(String[] stringArray, String searchString) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(searchString))
                return true;
        }
        return false;
    }*/
}
