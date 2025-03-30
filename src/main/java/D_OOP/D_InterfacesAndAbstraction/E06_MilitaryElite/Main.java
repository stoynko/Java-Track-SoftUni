package D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite;

import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Enums.Corp;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Enums.MissionState;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations.*;
import D_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Private> privates = new ArrayList<>();
        List<LieutenantGeneralImpl> generals = new ArrayList<>();
        List<EngineerImpl> engineers = new ArrayList<>();
        List<CommandoImpl> commandos = new ArrayList<>();
        List<SpyImpl> spies = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String[] inputData = input.split("\\s+");
            String soldierRank = inputData[0];
            int id = Integer.parseInt(inputData[1]);
            String firstName = inputData[2];
            String lastName = inputData[3];

            switch (soldierRank) {

                case "Private":
                    double salary = Double.parseDouble(inputData[4]);
                        PrivateImpl priv = new PrivateImpl(firstName, lastName, id, salary);
                        privates.add(priv);
                        System.out.println(priv);
                    break;

                case "LieutenantGeneral":
                    salary = Double.parseDouble(inputData[4]);
                    LieutenantGeneralImpl general = new LieutenantGeneralImpl(firstName, lastName, id, salary);
                    addPrivates(inputData, general, privates);
                    System.out.println(general);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(inputData[4]);
                    EngineerImpl engineer = null;
                    try {
                        Corp corp = Corp.valueOf(inputData[5]);
                        engineer = new EngineerImpl(firstName, lastName, id, salary, corp);
                    } catch (IllegalArgumentException e) {
                        break;
                    }
                    addRepairs(inputData, engineer);
                    System.out.println(engineer);
                    break;

                case "Commando":
                    salary = Double.parseDouble(inputData[4]);
                    CommandoImpl commando = null;
                    try {
                        Corp corp  = Corp.valueOf(inputData[5]);
                        commando = new CommandoImpl(firstName, lastName, id, salary, corp);
                    } catch (IllegalArgumentException e) {
                        break;
                    }
                    addMissions(inputData, commando);
                    System.out.println(commando);
                    break;

                case "Spy":
                    String codeNumber = inputData[4];
                    SpyImpl spy = new SpyImpl(firstName, lastName, id, codeNumber);
                    System.out.println(spy);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void addPrivates(String[] inputData, LieutenantGeneralImpl general, List<Private> privates) {
        for (int index = 5; index < inputData.length; index++) {
            for (Private p : privates) {
                general.addPrivate(p);
            }
        }
    }

    private static void addRepairs(String[] inputData, EngineerImpl engineer) {
        for (int index = 6; index < inputData.length; index += 2) {
            String partName = inputData[index];
            int hoursWorked = Integer.parseInt(inputData[index + 1]);
            try {
                RepairImpl repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static void addMissions(String[] inputData, CommandoImpl commando) {
        for (int index = 6; index < inputData.length; index += 2) {
            String missionName = inputData[index];
            try {
                MissionState missionState = MissionState.valueOf(inputData[index + 1]);
                MissionImpl mission = new MissionImpl(missionName, missionState);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }
}