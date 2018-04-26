package main;

import entity.Appliance;

import java.lang.reflect.Field;
import java.util.List;

public class PrintApplianceInfo {

    public void printProducts(List<Appliance> list) throws NoSuchFieldException,IllegalAccessException{
        if(list.isEmpty()){
            System.out.println("There are no such products!");
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                printProduct(list.get(i));
            }
        }
    }

    private static void printProduct(Appliance product) throws NoSuchFieldException,IllegalAccessException{
        Field[] fields = product.getClass().getDeclaredFields();
        System.out.print(product.getClass().getSimpleName()+": ");
        for(Field f: fields) {
            f.setAccessible(true);
            System.out.print(f.getName()+" = "+f.get(product)+", ");
        }
        System.out.println();
    }
    // you may add your own code here

}