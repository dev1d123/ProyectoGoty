import javax.swing.*;

public class Unit_Obrero extends Unit_Futurista{
    public final int COSTO = 60;
    public final int MATPRIMA = 0;
    public final int MANUTEN = 1;

    public Unit_Obrero(){
        super("Obrero", 50, 0, 0, 0, 0);
    }
    public ImageIcon getIcon(){
        return null;
    }
    public void hacerAccion(Reino r){
    }
}
