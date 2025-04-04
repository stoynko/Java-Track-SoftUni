package D_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics;

public class BlackMagic extends MagicImpl {

    public static final int BLACK_MAGIC_ADDITIONAL_BULLETS_FIRED = 9;

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() >= DEFAULT_BULLETS_FIRED + BLACK_MAGIC_ADDITIONAL_BULLETS_FIRED) {
            int initialBullets = super.getBulletsCount();
            int newBulletCount = initialBullets - (DEFAULT_BULLETS_FIRED + BLACK_MAGIC_ADDITIONAL_BULLETS_FIRED);
            super.setBulletsCount(newBulletCount);
            return DEFAULT_BULLETS_FIRED + BLACK_MAGIC_ADDITIONAL_BULLETS_FIRED;
        } else {
            return 0;
        }
    }
}
