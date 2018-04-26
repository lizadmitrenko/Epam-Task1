package entity.criteria;

import java.util.HashMap;
import java.util.Map;
public class Criteria {

    private String productName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void set(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }
}
