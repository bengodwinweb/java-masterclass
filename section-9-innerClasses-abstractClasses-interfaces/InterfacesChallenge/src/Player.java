import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private String weapon;

    public Player(String name, int attack, int defense, int health, String weapon) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.weapon = weapon;
    }

    public void levelUp() {
        attack += 5;
        defense += 5;
        health += 5;
    }

    public void heal() {
        health += 5;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.attack);
        values.add(2, "" + this.defense);
        values.add(3, "" + this.health);
        values.add(4, weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() == 5) {
            this.name = savedValues.get(0);
            this.attack = Integer.parseInt(savedValues.get(1));
            this.defense = Integer.parseInt(savedValues.get(2));
            this.health = Integer.parseInt(savedValues.get(3));
            this.weapon = savedValues.get(4);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
