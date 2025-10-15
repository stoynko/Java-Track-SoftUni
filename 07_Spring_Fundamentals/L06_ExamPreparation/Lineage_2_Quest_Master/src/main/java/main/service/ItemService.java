package main.service;

import main.model.Item;
import main.model.Player;
import main.repository.ItemRepository;
import main.web.dto.CreateItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAllByOrderByCreatedOnDescXpBonusMultiplierDesc();
    }

    public void createNewItem(CreateItemRequest createItemRequest, Player player) {
        Item item = Item.builder()
                .name(createItemRequest.getName())
                .type(createItemRequest.getType())
                .xpBonusMultiplier(createItemRequest.getXpBonusMultiplier())
                .iconUrl(createItemRequest.getIconUrl())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname()).build();

        itemRepository.saveAndFlush(item);
    }
}
