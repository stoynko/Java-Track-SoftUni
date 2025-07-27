package E02_Car_Dealer.data.dtos.part;

public class PartRelationsDTO {

    private final Long supplierId;

    public PartRelationsDTO(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }
}
