package main.model;

import lombok.Getter;

@Getter
public enum MobType {

    COMMON("Common"),
    BLUE_CHAMPION("Blue Champion"),
    RED_CHAMPION("Red Champion");

    private final String mobType;

    MobType(final String mobType) {
        this.mobType = mobType;
    }

}
