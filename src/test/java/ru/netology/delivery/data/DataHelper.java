package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataHelper {
    private DataHelper() {
    }

    public static String generateDate(int daysToAdd) {
        LocalDate date = LocalDate.now().plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }



    public static String generateCity(Faker faker) {
        return faker.address().cityName();
    }

    public static String generateName(Faker faker) {
        return faker.name().fullName();
    }

    public static String generatePhone(Faker faker) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private static Faker faker;

        private Registration() {
        }

        public static UserInfo generateUser(String locale, int i, String s) {
            faker = new Faker(new Locale(locale));
            return new UserInfo(generateCity(faker), generateName(faker), generatePhone(faker));
        }
    }


    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

    }

}


