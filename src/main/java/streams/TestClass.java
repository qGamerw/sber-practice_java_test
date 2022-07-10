package streams;

public class TestClass {
    
    private int hp;
    private int damage;
    private String name;

    public TestClass() {
        name = "name";
        hp = 100;
        damage = 1;
    }
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }
}
