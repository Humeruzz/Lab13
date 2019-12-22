import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> cashes = new ArrayList<String>();
        cashes.add("128 RUB");
        cashes.add("48.78 EU");
        cashes.add("27USD");
        cashes.add("12RUB");
        cashes.add("0 usd");
        cashes.add("Twenty EU");
        cashes.add("28 RUB");
        cashes.add("10 EU");
        cashes.add("100 USD");
        System.out.println("Все запросы по категории \"Деньги\":");
        for (int i = 0; i < cashes.size(); i++) {
            String cashRequest = cashes.get(i);
            System.out.println(cashRequest);
        }
        Pattern pattern = Pattern.compile("^([0-9]|([0-9]+\\.+[0-9]))+\\s(RUB|EU|USD)");
        Iterator<String> iterator = cashes.iterator();
        while (iterator.hasNext()) {
            Matcher match = pattern.matcher(iterator.next());
            if (!match.matches()) {
                iterator.remove();
            }
        }
        System.out.println("Все верные запросы по категории \"Деньги\":");
        for (int i = 0; i < cashes.size(); i++) {
            String cashRequest = cashes.get(i);
            System.out.println(cashRequest);
        }
        System.out.println("\n");

        // Second task
        System.out.print("Введите пароль: ");
        String password;
        Pattern patternPASS = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
        Matcher matchPIN;
        do {
            password = in.next();
            matchPIN = patternPASS.matcher(password);
            if (!matchPIN.matches()) {
                System.out.println("Небезопасный пароль! \n" +
                        "Должно быть не менее 8 символов, включая цифры, заглавные и маленькие англисйкие буквы!");
                System.out.print("Введите пароль: ");
            }
        } while (!matchPIN.matches());
        System.out.println("Надёжный пароль!");
    }
}
