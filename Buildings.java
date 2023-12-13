package images;

public class Buildings{
    private int life;
    private int attack;
    private int defense;
    private int absorption;

    public Buildings(int life, int attack, int defense, int absorption) {
        this.life = life;
        this.attack = attack;
        this.defense = defense;
        this.absorption = absorption;
    }

    // Métodos getters y setters
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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

    public int getAbsorption() {
        return absorption;
    }

    public void setAbsorption(int absorption) {
        this.absorption = absorption;
    }
}