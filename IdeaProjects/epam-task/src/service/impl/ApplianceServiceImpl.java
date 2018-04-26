package service.impl;

import dao.ApplianceDAO;
import dao.DAOFactory;
import entity.Appliance;
import entity.criteria.Criteria;
import service.ApplianceService;
import service.validate.Validator;

import java.io.IOException;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public Appliance find(Criteria criteria) throws IllegalAccessException, IOException{
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        Appliance appliance = applianceDAO.find(criteria);

        // you may add your own code here

        return appliance;
    }

}

//you may add your own new classes
