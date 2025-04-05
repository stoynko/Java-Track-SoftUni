package D_Java_OOP.X_ExamPreparations.ExamPrep_09;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E02_MagicGameTesting.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class MagicianTests {

    public static final String VALID_USERNAME = "Ivan";
    public static final String INVALID_USERNAME = "";
    public static final String NULL_USERNAME = null;
    public static final int VALID_HEALTH = 2;
    public static final int INVALID_HEALTH = -10;
    public static final int ONE_DAMAGE_TO_INFLICT = 1;
    public static final int TWO_DAMAGE_TO_INFLICT = 2;

    public static final String MAGIC_A_NAME = "Fireball";
    public static final String MAGIC_B_NAME = "Frost";
    public static final String MAGIC_C_NAME = "Spike";
    public static final Magic NULL_MAGIC = null;

    public static final int MAGIC_A_BULLETS = 10;
    public static final int MAGIC_B_BULLETS = 5;
    public static final int MAGIC_C_BULLETS = 3;

    Magician magician;
    Magic magicA;
    Magic magicB;
    Magic magicC;
    @BeforeEach
    public void init() {
        magician = new Magician(VALID_USERNAME, VALID_HEALTH);
        magicA = new Magic(MAGIC_A_NAME, MAGIC_A_BULLETS);
        magicB = new Magic(MAGIC_B_NAME, MAGIC_B_BULLETS);
        magicC = new Magic(MAGIC_C_NAME, MAGIC_C_BULLETS);
        magician.addMagic(magicA);
        magician.addMagic(magicB);
    }

    @Test
    public void SetUsernameMethodThrowsNullPointerExceptionWhenNameisBlank() {
        Assertions.assertThrows(NullPointerException.class, () -> new Magician(INVALID_USERNAME, VALID_HEALTH));
    }

    @Test
    public void SetUsernameMethodThrowsNullPointerExceptionWhenNameisNull() {
        Assertions.assertThrows(NullPointerException.class, () -> new Magician(NULL_USERNAME, VALID_HEALTH));
    }

    @Test
    public void GeUsernameMethodReturnsUsername() {
        Assertions.assertEquals(VALID_USERNAME, magician.getUsername());
    }

    @Test
    public void SetHealthMethodThrowsIllegalArgumentExceptionWhenNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Magician(VALID_USERNAME, INVALID_HEALTH));
    }

    @Test
    public void GetHealthMethodReturnsHealth() {
        Assertions.assertEquals(VALID_HEALTH, magician.getHealth());
        magician.takeDamage(ONE_DAMAGE_TO_INFLICT);
        Assertions.assertEquals(VALID_HEALTH - ONE_DAMAGE_TO_INFLICT, magician.getHealth());
    }

    @Test
    public void GetMagicsMethodReturnsUnmodifiableCollection() {
        List<Magic> magicsList = magician.getMagics();
        Assertions.assertThrows(UnsupportedOperationException.class, magicsList::clear);
    }

    @Test
    public void TakeDamageMethodThrowsIllegalStateException() {
        magician.takeDamage(2);
        Assertions.assertThrows(IllegalStateException.class, () -> magician.takeDamage(ONE_DAMAGE_TO_INFLICT));
    }

    @Test
    public void TakeDamageMethodCorrectlyAppliesDamage() {
        magician.takeDamage(1);
        Assertions.assertEquals(VALID_HEALTH - ONE_DAMAGE_TO_INFLICT, magician.getHealth());
        magician.takeDamage(TWO_DAMAGE_TO_INFLICT);
        Assertions.assertNotEquals(VALID_HEALTH - ONE_DAMAGE_TO_INFLICT - TWO_DAMAGE_TO_INFLICT, magician.getHealth());
        Assertions.assertEquals(0, magician.getHealth());
    }

    @Test
    public void AddMagicMethodThrowsNullPointerExceptionWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> magician.addMagic(NULL_MAGIC));
    }

    @Test
    public void AddMagicMethodAddsCorrectly() {
        int initialSize = magician.getMagics().size();
        magician.addMagic(magicC);
        Assertions.assertEquals(initialSize + 1, magician.getMagics().size());
    }

    @Test
    public void RemoveMagicMethodRemovesCorrectly() {
        int initialSize = magician.getMagics().size();
        magician.removeMagic(magicA);
        Assertions.assertEquals(initialSize - 1, magician.getMagics().size());
        Assertions.assertTrue(magician.getMagics().stream().noneMatch(magic -> magic.getName().equals(MAGIC_A_NAME)));
    }

    @Test
    public void GetMagicMethodReturnsCorrectly() {
        Magic returnedMagic = magician.getMagic(MAGIC_A_NAME);
        Assertions.assertSame(magicA, returnedMagic);
    }
}

