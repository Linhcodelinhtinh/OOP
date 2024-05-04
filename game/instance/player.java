package OOP.game.instance;

public class player {

    private int HP;
    private int maxHP;
    private int xp;
    public static int atk;
    public static int def;
    public static int lvl;
    public static int numPotions;
    public static String name;

    player(int x, int y, int z){
        this.HP = x;
        this.maxHP = y;
        this.xp = z;
    }
    /* Getters & Setters */
    public int getHp(){
        return this.HP;
    }
    public void setHP(int hp){
        HP = hp;
    }

    // ... any other ones you need
}
