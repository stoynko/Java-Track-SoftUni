package E02_Car_Dealer.data.dtos.car;

import java.util.*;

public class CarRelationsDTO {

    private final List<Long> partIDs;

    public CarRelationsDTO(List<Long> partIDs) {
        this.partIDs = partIDs;
    }

    public List<Long> getPartIDs() {
        return partIDs;
    }
}
