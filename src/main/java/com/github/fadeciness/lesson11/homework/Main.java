package com.github.fadeciness.lesson11.homework;

import com.github.fadeciness.lesson11.homework.entity.Person;
import com.github.fadeciness.lesson11.homework.entity.Purchase;
import com.github.fadeciness.lesson11.homework.service.ShopService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");

        String command = args[0].substring(1);
        switch (command) {
            case "showProductsByPerson":
                String personName = args[1].trim();
                List<Purchase> purchases = ShopService.showProductsByPerson(personName);
                System.out.println("Список покупок: " + purchases);
                break;
            case "findPersonsByProductTitle":
                String productName = args[1].trim();
                List<Person> persons = ShopService.findPersonsByProductTitle(productName);
                System.out.println("Список людей: " + persons + ", купивших товар: " + productName);
                break;
            case "buy":
                String persName = args[1].trim();
                String prodName = args[2].trim();
                ShopService.buy(persName, prodName);
                break;
            case "removePerson":
                String pName = args[1].trim();
                ShopService.removePerson(pName);
                break;
            case "removeProduct":
                String proName = args[1].trim();
                ShopService.removeProduct(proName);
                break;
            case "avgPrice":
                String prsnName = args[1].trim();
                String prdctName = args[2].trim();
                Double avgPrice = ShopService.avgPrice(prsnName, prdctName);
                System.out.println("Человек: " + prsnName + " купил продукт: " + prdctName + " по средней цене: " + avgPrice);
                break;
            default:
                throw new UnsupportedOperationException("Unknown operation: " + command);
        }

        System.out.println("Program finished");
    }
}
