package dao;

import entity.Appliance;
import entity.criteria.Criteria;

import java.io.IOException;
import java.util.List;

public interface ApplianceDAO {
    Appliance find(Criteria criteria) throws IOException, IllegalAccessException;
    public List<Appliance> find(Criteria...criteria) throws IOException, IllegalAccessException;
}
