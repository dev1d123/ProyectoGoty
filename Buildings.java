import java.util.ArrayList;

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

    public class Ayuntamiento extends Buildings{
        private ArrayList<String> habilidades;
        public Ayuntamiento(){
            super(3000, 0, 3, 0);
            habilidades.add("Mejorar Reino");
            habilidades.add("Crear Edificio");
            habilidades.add("Destruir Edificio (Rendirse)");
        }
    }

    public class Marina extends Buildings{
        private ArrayList<String> habilidades;
        public Marina(){
            super(750, 100, 2, 0);
            habilidades.add("Generar Portaaviones");
            habilidades.add("Destruir Edificio");
        }
    }

    public class Cuartel extends Buildings{
        private ArrayList<String> habilidades;
        public Cuartel(){
            super(800, 75, 2, 0);
            habilidades.add("Generar Soldado");
            habilidades.add("Destruir Edificio");
        }
    }

    public class FuerzaAerea extends Buildings{
        private ArrayList<String> habilidades;
        public FuerzaAerea(){
            super(750, 150, 2, 0);
            habilidades.add("Generar Aviones");
            habilidades.add("Generar Caza");
            habilidades.add("Destruir Edificio");
        }
    }

    public class Supermercado extends Buildings{
        private ArrayList<String> habilidades;
        public Supermercado(){
            super(500, 0, 3, 0);
            habilidades.add("Mejorar Manutencion");
            habilidades.add("Mejorar Recoleccion");
            habilidades.add("Destruir Edificio");
        }
    }

    public class Manhattan extends Buildings{
        private ArrayList<String> habilidades;
        public Manhattan(){
            super(700, 0, 3, 0);
            habilidades.add("Adiestramiento BioT");
            habilidades.add("Medicina Avanzada");
            habilidades.add("Equipamiento Bas.");
            habilidades.add("Little Boy");
        }
    }

    public class Domo extends Buildings{
        private ArrayList<String> habilidades;
        public Domo(){
            super(800, 1200, 0, 0);
            habilidades.add("Añadir Domo");
            habilidades.add("Destruir Edificio");
        }
    }
}