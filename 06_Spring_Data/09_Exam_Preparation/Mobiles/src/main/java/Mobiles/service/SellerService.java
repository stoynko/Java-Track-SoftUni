package Mobiles.service;

import java.io.IOException;

// TODO: Implement all methods
public interface SellerService {

    boolean areImported();

    String readSellersFromFile() throws IOException;

    String importSellers() throws IOException;

}
