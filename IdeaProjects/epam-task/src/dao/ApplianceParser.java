package dao;
import entity.*;

import java.lang.reflect.Field;

public class ApplianceParser {
    private final String oven = "Oven";
    private final String laptop = "Laptop";
    private final String refrigerator = "Refrigerator";
    private final String speakers = "Speakers";
    private final String tabletPC = "TabletPC";
    private final String textBook = "TextBook";
    private final String newspaper = "Newspaper";
    private final String vacuumCleaner = "VacuumCleaner";

    public Appliance parse(String line) throws IllegalAccessException{
        String [] arr = line.split(":|;");
        Appliance product = new Appliance();

        if(arr[0].equalsIgnoreCase(laptop)) {
            return fillProductFields(arr[1],new Laptop());
        }
        else if(arr[0].equalsIgnoreCase(refrigerator)) {
            return fillProductFields(arr[1],new Refrigerator());
        }
        else if(arr[0].equalsIgnoreCase(oven)) {
            return fillProductFields(arr[1],new Oven());
        }
        else if(arr[0].equalsIgnoreCase(newspaper)) {
            return fillProductFields(arr[1],new Newspaper());
        }
        else if(arr[0].equalsIgnoreCase(tabletPC)) {
            return fillProductFields(arr[1],new TabletPC());
        }
        else if(arr[0].equalsIgnoreCase(textBook)) {
            return fillProductFields(arr[1],new TextBook());
        }
        else if(arr[0].equalsIgnoreCase(vacuumCleaner)) {
            return fillProductFields(arr[1],new VacuumCleaner());
        }
        return product;
    }

    private static Appliance fillProductFields(String line,Appliance product) throws IllegalAccessException{
        Field[] fields = product.getClass().getDeclaredFields();
        String [] arr = line.split(",");
        String [] option;
        for(String item: arr) {
            item = item.trim();
            option = item.split("=");
            option[0]=option[0].toLowerCase();
            fillAppropriateField(product,fields,option[0],option[1]);
        }
        return product;
    }

    private static void fillAppropriateField(Appliance product, Field[]fields, String field, String value) throws IllegalAccessException{
        for(Field f: fields) {
            if(f.getName().equalsIgnoreCase(field)) {
                f.setAccessible(true);
                chooseAppropriateFieldValue(product,f,value);
            }
        }
    }
    private static void chooseAppropriateFieldValue(Appliance product, Field f, String value) throws IllegalAccessException{
        if(f.getType()==String.class) {
            f.set(product, value);
        }
        else if (f.getType()==Integer.class) {
            f.set(product, Integer.parseInt(value));
        }
        else if (f.getType()==Double.class) {
            f.set(product, Double.parseDouble(value));
        }
    }

}
