import entities.*;
import jakarta.persistence.*;

import java.time.*;
import java.util.*;

public class Main {

/* Your task is to create table wizard_deposits using the Code First approach. The table should contain the following fields:
    •	id – Primary Key (number in the range [1, 231-1])
    •	first_name – Text field with a max length of 50 symbols
    •	last_name - Text field with a max length of 60 symbols. Required
    •	notes – Text field with a max length of 1000 symbols
    •	age – Required
    •	magic_wand_creator – Text field with a max length of 100 symbols
    •	magic_wand_size – Number in the range [1, 215-1]
    •	deposit_group - Text field with a max length of 20 symbols
    •	deposit_start_date – Date and time field
    •	deposit_amount – Floating point number field
    •	deposit_interest - Floating point number field
    •	deposit_charge - Floating point number field
    •	deposit_expiration_date – Date and time field
    •	is_deposit_expired – Boolean field */

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        List<WizardDeposit> deposits = createWizardDeposits();
        deposits.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<WizardDeposit> createWizardDeposits() {

        WizardDeposit depositA = new WizardDeposit();
        depositA.setFirstName("Alaric");
        depositA.setLastName("Stormweaver");
        depositA.setText("Master of elemental conjuration and spellbinding.");
        depositA.setAge((short) 120);
        depositA.setMagicWandCreator("Elderwood Enchantments");
        depositA.setMagicWandSize((short) 15);
        depositA.setDepositGroup("Gold Tier");
        depositA.setDepositStartDate(Instant.parse("2023-06-01T00:00:00Z"));
        depositA.setDepositAmount(15000.00);
        depositA.setDepositInterest(4.75);
        depositA.setDepositCharge(250.00);
        depositA.setDepositExpirationDate(Instant.parse("2028-06-01T00:00:00Z"));
        depositA.setDepositExpired(false);

        WizardDeposit depositB = new WizardDeposit();
        depositB.setFirstName("Mirella");
        depositB.setLastName("Dawnshade");
        depositB.setText("Scholar of illusions and keeper of arcane vaults.");
        depositB.setAge((short) 85);
        depositB.setMagicWandCreator("Moonlit Makers");
        depositB.setMagicWandSize((short) 12);
        depositB.setDepositGroup("Silver Tier");
        depositB.setDepositStartDate(Instant.parse("2022-03-15T00:00:00Z"));
        depositB.setDepositAmount(8900.00);
        depositB.setDepositInterest(3.95);
        depositB.setDepositCharge(125.00);
        depositB.setDepositExpirationDate(Instant.parse("2027-03-15T00:00:00Z"));
        depositB.setDepositExpired(false);

        WizardDeposit depositC = new WizardDeposit();
        depositC.setFirstName("Thorn");
        depositC.setLastName("Blackroot");
        depositC.setText("Necromancer turned banker. Handles high-risk vaults.");
        depositC.setAge((short) 149);
        depositC.setMagicWandCreator("Obsidian Forge");
        depositC.setMagicWandSize((short) 18);
        depositC.setDepositGroup("Platinum Tier");
        depositC.setDepositStartDate(Instant.parse("2018-11-10T00:00:00Z"));
        depositC.setDepositAmount(22500.00);
        depositC.setDepositInterest(5.25);
        depositC.setDepositCharge(300.00);
        depositC.setDepositExpirationDate(Instant.parse("2025-11-10T00:00:00Z"));
        depositC.setDepositExpired(true);

        return List.of(depositA, depositB, depositC);
    }
}
