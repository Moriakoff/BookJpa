package moriakoff.bookjpa.configuration;

import moriakoff.bookjpa.dao.Book;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomConfig {
    static Random random = new Random();

    public static final String[] FIRSTNAMES =
            {"John", "Robert", "Jackob", "Thomas", "Edward", "William", "Henry", "George", "Gregory", "Charles"};
    public static final String[] LASTNAMES =
            {"Johnson", "Smith", "Lee", "Linn", "Fox", "Simpson", "Ford", "Piper", "Moor", "Philips"};

    public static final String[] PUBLISHER_NAMES = {"Star", "Red Star", "Black Star", "Golden Star", "Dead Star",
            "Sun", "Green Sun", "Sea", "Yellow Sea", "Red Sea"};

    public static final String[] TITLES
            = {"Day and Night", "Summer and Winter", "Bread and Stone", "Eagle and Snake", "Head and Ass",
            "Love and Hate", "Red and Black", "Girls and Vodka", "Church and Yoghurt", "Drugs and Sex"};

    public static LocalDate randomDate(int year) {
        LocalDate start = LocalDate.of(year, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
    }

    public static String randomAuthor(){
        return RandomConfig.FIRSTNAMES[random.nextInt(RandomConfig.FIRSTNAMES.length)] + " "
                + RandomConfig.LASTNAMES[random.nextInt(RandomConfig.LASTNAMES.length)];
    }

    public static String randomPublisher(){
        return RandomConfig.PUBLISHER_NAMES[random.nextInt(RandomConfig.PUBLISHER_NAMES.length)];
    }

    public static String randomTitle(){
        return RandomConfig.TITLES[random.nextInt(RandomConfig.TITLES.length)];
    }

    public static double randomPrice(){
        return ThreadLocalRandom.current().nextDouble(50.50, 800.00);
    }

    public static Book randomBook(){
        return new Book(randomTitle(), randomAuthor(), randomPublisher(), randomDate(1940), randomPrice());
    }
}
