package main.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.model.Item;
import main.model.PlayerClass;
import org.hibernate.validator.constraints.URL;

@Setter @Getter @NoArgsConstructor
public class CreateQuestRequest {

    @NotBlank
    @Size(min = 6, max = 26)
    String title;

    @NotNull
    Item rewardItem;

    @NotNull
    PlayerClass eligibleClass;

    @NotBlank
    @Size(min = 110, max = 128)
    String questDescription;

    @URL
    @NotBlank
    String imgUrl;

    @NotNull
    @Min(1) @Max(13)
    double xpPoints;
}
