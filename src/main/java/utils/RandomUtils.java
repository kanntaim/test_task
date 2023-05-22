package utils;

import com.github.javafaker.Faker;

import java.util.Date;

public class RandomUtils {
    public synchronized static String generateUniqueRandomString(){ //synced to avoid same timestamp
        return Faker.instance().name().firstName() + new Date().getTime();
    }
}
