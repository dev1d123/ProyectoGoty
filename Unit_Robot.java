import javax.swing.*;

public class Unit_Robot extends Unit_Futurista{
    public final int COSTO = 100;
    public final int MATPRIMA = 5;
    public final int MANUTEN = 8;

    public Unit_Robot(){
        super("Robot", 5, 0, 0, 0, 0);
    }
    public ImageIcon getIcon(){
        return null;
    }
    public void hacerAccion(Reino r){
    }
}
