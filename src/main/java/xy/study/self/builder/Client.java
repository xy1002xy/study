package xy.study.self.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-10 23:16
 * @desc: 测试构造者模式
 **/
public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {


        Hero test =
                new Hero.Builder(Profession.MAGE, "Riobard",HairType.LONG_CURLY,HairColor.BLACK,Armor.CHAIN_MAIL,
                        Weapon.DAGGER).build();
        LOGGER.info(test.toString());
        Hero mage =
                new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK)
                        .withWeapon(Weapon.DAGGER).build();
        LOGGER.info(mage.toString());
        Hero warrior =
                new Hero.Builder(Profession.WARRIOR, "Amberjill").withHairColor(HairColor.BLOND)
                        .withHairType(HairType.LONG_CURLY).withArmor(Armor.CHAIN_MAIL).withWeapon(Weapon.SWORD)
                        .build();
        LOGGER.info(warrior.toString());

        Hero thief =
                new Hero.Builder(Profession.THIEF, "Desmond").withHairType(HairType.BALD)
                        .withWeapon(Weapon.BOW).build();
        LOGGER.info(thief.toString());

    }

}
