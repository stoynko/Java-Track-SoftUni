package Y_ExamPreparations.ExamPrep_05.E01_Restaurant.repositories;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.client.*;
import java.util.*;

/*The ClientRepository class is a repository for clients.
Data
•	clients – a collection of clients
Behavior
void add(Client client)
•	Adds a client to the collection.
•	Every client is unique in the collection.
o	It is guaranteed that there will not be a client with the same name.
boolean remove(Client client)
•	Removes a client from the collection. Returns true if the deletion was successful.
Client byName(String name)
•	Returns a client with that name.
•	If the client is not in the collection, return null.
Collection<Client> getCollection()
•	Returns an unmodifiable collection of clients.
*/
public class ClientRepository implements Repository<Client> {

    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(this.clients);
    }

    @Override
    public void add(Client entity) {
        this.clients.add(entity);
    }

    @Override
    public boolean remove(Client entity) {
        return clients.remove(entity);
    }

    @Override
    public Client byName(String name) {
        return this.clients.stream().filter(client -> client.getName().equals(name)).findFirst().orElse(null);
    }
}
