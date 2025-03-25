package D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.core;

import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins.*;
import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.*;
import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.pools.*;
import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.repositories.*;

import java.util.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository = new FoodRepositoryImpl();
    private Collection<Pool> pools;

    public ControllerImpl() {
        this.pools = new ArrayList<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {
        Pool pool;
        switch (poolType) {
            case "DeepWaterPool":
                pool = new DeepWaterPool(poolName);
                break;
            case "ShallowWaterPool":
                pool = new ShallowWaterPool(poolName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_POOL_TYPE);
        }

        if (this.pools.stream().anyMatch(p -> p.getName().equals(poolName))) {
            throw new NullPointerException(ExceptionMessages.POOL_EXISTS);
        }
        this.pools.add(pool);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Squid":
                food = new Squid();
                break;
            case "Herring":
                food = new Herring();
                break;
            case "Mackerel":
                food = new Mackerel();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }
        pool.getFoods().add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        Dolphin dolphin;
        switch (dolphinType) {
            case "BottleNoseDolphin":
                dolphin = new BottleNoseDolphin(dolphinName, energy);
                break;
            case "SpottedDolphin":
                dolphin = new SpottedDolphin(dolphinName, energy);
                break;
            case "SpinnerDolphin":
                dolphin = new SpinnerDolphin(dolphinName, energy);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DOLPHIN_TYPE);
        }
        if (dolphin.getEnergy() <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }
        if (pool.getDolphins().stream().anyMatch(d -> d.getName().equals(dolphinName))) {
            throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_EXISTS);
        }
        if (dolphinType.equals("BottleNoseDolphin") && poolName.equals("DeepWaterPool")) {
            pool.addDolphin(dolphin);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
        } else if (dolphinType.equals("BottleNoseDolphin") && poolName.equals("ShallowWaterPool")) {
            return ConstantMessages.POOL_NOT_SUITABLE;
        } else if (dolphinType.equals("SpinnerDolphin") && poolName.equals("DeepWaterPool")) {
            return ConstantMessages.POOL_NOT_SUITABLE;
        } else if (dolphinType.equals("SpinnerDolphin") && poolName.equals("ShallowWaterPool")) {
            pool.addDolphin(dolphin);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
        } else {
            pool.addDolphin(dolphin);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
        }
    }

    @Override
    public String feedDolphins(String poolName, String food) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        Food fd = null;
        for (Food poolFood : pool.getFoods()) {
            if (poolFood.getClass().getSimpleName().equals(food)) {
                fd = poolFood;
                break;
            }
        }
        if (fd == null) {
            throw new IllegalArgumentException(ExceptionMessages.NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }

        int dolphinsFed = 0;

        for (Dolphin dolphin : pool.getDolphins()) {
            dolphin.eat(fd);
            dolphinsFed++;
        }
        pool.getFoods().remove(fd);
        return String.format(ConstantMessages.DOLPHINS_FED, dolphinsFed, poolName);
    }

    @Override
    public String playWithDolphins(String poolName) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        if (pool.getDolphins().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_DOLPHINS);
        }

        Iterator<Dolphin> iterator = pool.getDolphins().iterator();
        int dolphinsRemoved = 0;
        while (iterator.hasNext()) {
            Dolphin dolphin = iterator.next();
            dolphin.jump();
            if (dolphin.getEnergy() <= 0) {
                iterator.remove();
                dolphinsRemoved++;
            }
        }

        return String.format(ConstantMessages.DOLPHINS_PLAY, poolName, dolphinsRemoved);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Pool pool : pools) {
            output.append(String.format("Dolphins in pool %s:", pool.getName())).append(System.lineSeparator());
            if (!pool.getDolphins().isEmpty())  {
                List<String> dolphinsInfo = new ArrayList<>();
                for (Dolphin dolphin : pool.getDolphins()) {
                    dolphinsInfo.add(String.format("%s - %s", dolphin.getName(), dolphin.getEnergy()));
                }
                String dolphinsOutput = String.join(", ", dolphinsInfo);
                output.append(dolphinsOutput).append(System.lineSeparator());
            } else {
                output.append("none").append(System.lineSeparator());
            }
        }
        return output.toString();
    }
}
