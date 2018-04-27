package main;


import entity.Appliance;
import entity.criteria.Criteria;
import service.ApplianceService;
import service.ServiceFactory;

import java.io.IOException;
import java.util.List;

import static entity.criteria.SearchCriteria.*;

public class Main {

    public static void main(String[] args)throws IllegalAccessException, NoSuchFieldException,IOException {
        List<Appliance> appliance;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.set(Oven.CAPACITY.toString(), 3);

        appliance = service.find(criteriaOven);

        PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.set(Oven.HEIGHT.toString(), 200);
        criteriaOven.set(Oven.DEPTH.toString(), 300);

        appliance = service.find(criteriaOven);

        PrintApplianceInfo.print(appliance);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.set(TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.set(TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.set(TabletPC.MEMORY_ROM.toString(), 4);

        appliance = service.find(criteriaOven);// find(Object...obj)

        PrintApplianceInfo.print(appliance);

    }

}
