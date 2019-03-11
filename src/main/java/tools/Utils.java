package tools;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static int getRandomNumberInRange(int min, int max) throws IllegalArgumentException{

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static Date getRandomDateInRange(Date minDate, Date maxDate) throws IllegalArgumentException{
        if(maxDate.before(minDate)){
            throw new IllegalArgumentException("minDate must be a date before maxDate");
        }
        return new Date(ThreadLocalRandom.current().nextLong(minDate.getTime(), maxDate.getTime()));

    }
}
