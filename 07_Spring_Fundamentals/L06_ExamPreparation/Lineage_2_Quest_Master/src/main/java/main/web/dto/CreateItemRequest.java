package main.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.model.ItemType;
import org.hibernate.validator.constraints.URL;

@Setter
@Getter
@NoArgsConstructor
public class CreateItemRequest {

    @NotBlank
    @Size(min = 6, max = 26)
    private String name;

    @NotNull
    private ItemType type;

    @Min(1) @Max(3)
    private double xpBonusMultiplier;

    @URL
    @NotBlank
    private String iconUrl;
}
