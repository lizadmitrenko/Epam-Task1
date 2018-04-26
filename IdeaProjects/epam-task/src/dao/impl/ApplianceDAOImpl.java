package dao.impl;

import dao.ApplianceDAO;
import dao.ApplianceParser;
import dao.ApplianceReader;
import entity.Appliance;
import entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplianceDAOImpl implements ApplianceDAO{
    @Override
   public Appliance find(Criteria criteria) throws IOException, IllegalAccessException{
        Scanner sc = new Scanner(new File("appliances_db.txt"));
        ApplianceParser applianceParser = new ApplianceParser();
       List<Appliance> list = new ArrayList<>();
       list = ApplianceReader.readFile(sc,applianceParser,list);

    }

    public List<Appliance> find(Criteria...criteria) throws IOException, IllegalAccessException{
        List<Appliance> list = new ArrayList<>();
        for(Criteria item:criteria){
            list.add(find(item));
        }
        return list;
    }



}
