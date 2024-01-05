public abstract class Unit_Contemporaneo extends Unit{
    protected int balasEspeciales = 0;
    public Unit_Contemporaneo(String nombre, int vida, int ataque, int defensa, int velocidad, int pp){
        super(nombre, vida, ataque, defensa, velocidad, pp);
    }           
    public abstract void setBalasEspeciales();
}
