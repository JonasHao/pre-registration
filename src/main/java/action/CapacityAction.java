package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Capacity;

import java.util.List;

/**
 * Created by Kil on 5/24/2016.
 */
public class CapacityAction extends DefaultActionSupport {

    private List<Capacity> capacities;


    public List<Capacity> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }

}
