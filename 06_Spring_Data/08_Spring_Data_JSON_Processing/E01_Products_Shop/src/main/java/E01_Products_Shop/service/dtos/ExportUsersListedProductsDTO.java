package E01_Products_Shop.service.dtos;

import E01_Products_Shop.data.*;

import java.util.*;

public class ExportUsersListedProductsDTO {

    private long usersCount;

    private List<ExportSellerWithListedProductsDTO> users;

    public ExportUsersListedProductsDTO() { }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }

    public void setUsers(List<ExportSellerWithListedProductsDTO> users) {
        this.users = users;
    }

    public long getUsersCount() {
        return usersCount;
    }

    public List<ExportSellerWithListedProductsDTO> getUsers() {
        return users;
    }
}
