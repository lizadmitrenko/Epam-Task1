package service;

import entity.Appliance;
import entity.criteria.Criteria;

import java.io.IOException;
import java.util.List;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria) throws IOException, IllegalAccessException;

}