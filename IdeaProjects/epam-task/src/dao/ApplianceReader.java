package dao;

import entity.Appliance;

import java.util.List;
import java.util.Scanner;

public class ApplianceReader {
    public static List<Appliance> readFile(Scanner sc, ApplianceParser parser, List<Appliance>products)throws IllegalAccessException{
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            parser = new ApplianceParser();
            products.add(parser.parse(line));
        }
        return products;
    }
}
