package main.service;

import jakarta.validation.Valid;
import main.model.Player;
import main.model.PlayerClass;
import main.model.Quest;
import main.repository.QuestRepository;
import main.web.dto.CreateQuestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestService {

    private final QuestRepository questRepository;
    private final PlayerService playerService;

    @Autowired
    public QuestService(QuestRepository questRepository, PlayerService playerService) {
        this.questRepository = questRepository;
        this.playerService = playerService;
    }

    public List<Quest> getAllQuests() {
        return questRepository.findAllByOrderByCreatedOnDescXpDesc();
    }

    public void createQuest(@Valid CreateQuestRequest createQuestRequest, Player player) {
        Quest quest = Quest.builder()
                .title(createQuestRequest.getTitle())
                .rewardItem(createQuestRequest.getRewardItem())
                .eligibleClass(createQuestRequest.getEligibleClass())
                .description(createQuestRequest.getQuestDescription())
                .bannerUrl(createQuestRequest.getImgUrl())
                .xp(createQuestRequest.getXpPoints())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname()).build();

        questRepository.saveAndFlush(quest);
    }


    public List<Quest> findEligibleQuests(PlayerClass playerClass) {
        return questRepository.findAllByEligibleClass(playerClass);
    }

    @Transactional
    public void captureQuest(UUID questId, Player player) {
        Quest quest = questRepository.findById(questId).orElseThrow(() -> new RuntimeException("Quest does not exist."));

        if (quest.getCapturer() != null ) {
            throw new RuntimeException("Quest was already captured.");
        }
        quest.setCapturer(player);
        questRepository.saveAndFlush(quest);

        double currentXp = player.getXp();
        double xpFromQuest = quest.getRewardItem().getXpBonusMultiplier();
        player.setXp(currentXp + xpFromQuest);
        playerService.update(player);
    }

    public Quest findById(UUID questId) {
        return questRepository.findById(questId).get();
    }
}
