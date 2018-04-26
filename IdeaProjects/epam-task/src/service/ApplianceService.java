package service;

import entity.Appliance;
import entity.criteria.Criteria;

public interface ApplianceService {

    Appliance find(Criteria criteria);

}