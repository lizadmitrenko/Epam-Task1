package dao.impl;

import dao.ApplianceDAO;
import dao.ApplianceParser;
import dao.ApplianceReader;
import entity.Appliance;
import entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class ApplianceDAOImpl implements ApplianceDAO {
    @Override
    public List<Appliance> find(Criteria criteria) throws IOException, IllegalAccessException {
        Scanner sc = new Scanner(new File("appliances_db.txt"));
        ApplianceParser applianceParser = new ApplianceParser();
        List<Appliance> list = new ArrayList<>();
        list = ApplianceReader.readFile(sc, applianceParser, list);
        List<Appliance> searching = searchByGroupName(criteria, list);
        if (searching.isEmpty()) {
            searching = searchByOption(criteria, list);
        } else {
            searching = searchByOption(criteria, searching);
        }
        return searching;
    }

    //@Override
   /* public List<Appliance> find(Criteria... criteria) throws IOException, IllegalAccessException {
        List<Appliance> list = new ArrayList<>();
        for (Criteria item : criteria) {
            list.add(find(item));
        }
        return list;
    }*/

    private List<Appliance> searchByGroupName(Criteria criteria, List<Appliance> list) {
        List<Appliance> searched = new ArrayList<>();
        for (Appliance item : list) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(criteria.getProductName())) {
                searched.add(item);
            }
        }
        return searched;
    }

    private List<Appliance> searchByOption(Criteria criteria, List<Appliance> searched) throws IllegalAccessException{
        Map<String,Object> map = criteria.getCriteria();
        List<Appliance>list = new ArrayList<>();
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {//пока есть критерии
            Map.Entry<String, Object> entry = entries.next();
            for(Appliance item:searched){ //пока в списке есть элементы
                Field [] fields = item.getClass().getDeclaredFields();
                for(Field f: fields){
                    f.setAccessible(true);
                    if(f.getName().equalsIgnoreCase(entry.getKey())&&f.get(item).equals(entry.getValue())){
                        list.add(item);
                        break;
                    }
                }
            }
        }
        return list;
    }
}