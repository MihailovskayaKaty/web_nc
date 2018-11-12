package DataUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataUtil {

    /**
     * Шаблон даты, используемый для преобразования.
     */
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    /**
     * Форматировщик даты.
     */
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);


     //Возвращает полученную дату в виде хорошо отформатированной строки.

    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }



     //Преобразует строку, которая отформатирована по правилам шаблона
     //Возвращает null, если строка не может быть преобразована.

    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }


    //Проверяет, является ли строка корректной датой.

    public static boolean validDate(String dateString) {
        // Пытаемся разобрать строку.
        return DataUtil.parse(dateString) != null;
    }
}
