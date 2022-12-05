package ru.croc.task16;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Ваша команда разрабатывает приложение службы такси.
 * Вы работаете над модулем подбора водителя.
 * При этом модуль вы реализуете в виде отдельного Java-приложения,
 * работающего со стандартными потоками ввода-вывода.
 * На вход (System.in) оно принимает координаты клиента,
 * класс комфорта и список особых пожеланий в текстовом виде,
 * на выходе (System.out) выдает идентификатор ближайшего водителя на подходящем
 * авто.
 * 
 * В качестве аргументов командной строки приложению указывается следующая
 * последовательность:
 * координаты в формате <Широта, долгота>, класс комфорта, список особых
 * пожеланий.
 * 
 * Компаратор для сортировки реализуйте в виде лямбды.
 * Особые пожелания — конечный набор значений.
 * 
 */
public class Task16 {

    public static void main(String[] args) {

        List<Driver> drivers = Arrays.asList(
                new Driver("U-SnezhanaDenisovna-79995553535", "комфорт", "детское кресло", 60.9386, 31.3141),
                new Driver("K-IvanovIvan-79995553535", "комфорт", "детское кресло", 59.9486, 30.324),
                new Driver("K-PetrovPetr-79995553535", "комфорт", "детское кресло", 59.9386, 25.314),
                new Driver("K-PopovNikita-79995553535", "комфорт", "детское кресло", 58.9386, 30.314),
                new Driver("K-TrusovNikilay-79995553535", "комфорт", "детское кресло", 59.9386, 36.314),
                new Driver("U-GagarinFedor-79995553535", "эконом", "детское кресло", 59.9386, 30.314),
                new Driver("B-LimonovDmitriy-79995553535", "бизнес", "детское кресло", 59.9386, 30.314),
                new Driver("K-LevnovOleg-79995553535", "комфорт", "трезвый водитель", 59.9386, 30.314),
                new Driver("K-SokolovAlekssandr-79995553535", "комфорт", null, 59.9386, 30.314),
                new Driver("K-OrlovSergey-79995553535", "комфорт", null, 59.9386, 30.314));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя: ");
        System.out.print("<Широта>, <долгота>: ");
        String userCoordinatesString = scanner.nextLine();

        // String userCoordinatesString = "59.9386, 30.3141".trim(); // for testing!!!


        String[] userCoordinatesSting2 = userCoordinatesString.split(",");

        userCoordinatesSting2[0] = userCoordinatesSting2[0].trim();
        userCoordinatesSting2[1] = userCoordinatesSting2[1].trim();
        double latitude = Double.parseDouble(userCoordinatesSting2[0]);
        double longitude = Double.parseDouble(userCoordinatesSting2[1]);

        // double[] userCoordinates = new double[2];
        // userCoordinates[0] = Double.parseDouble(userCoordinatesString2[0]);
        // System.out.println(latitude);
        // System.out.println(longitude);

        System.out.print("Класс (эконом/комфорт/бизнес): ");
        // String classKomfort = scanner.nextLine();
        String classKomfort = "комфорт"; // for testing!!!
       

        System.out.print("У Вас есть особые пожелания? (Y/N): ");
        String question = scanner.nextLine();
        String additions = null;
        if (question.equals("Y")) {
        System.out.print("Введите Ваше пожелание (детское кресло/большой багажник/трезвый водитель): ");
        additions = scanner.nextLine();
        }

    


        //FOR TEST
        // String classKomfort = "комфорт"; // for testing!!!  59.9386, 30.3141
        // String additons = null;
        // additions = "детское кресло"; // for testing!!!


        
        Client client = new Client(classKomfort, additions, latitude, longitude);
        System.out.println("\nYour choice: " + latitude + ", " + longitude + ", " + classKomfort + ", " + additions);

        DriverSearch dS = new DriverSearch(drivers, client);
        System.out.println(dS.search());

    }

}
