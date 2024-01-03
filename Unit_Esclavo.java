import javax.swing.*;

public class Unit_Esclavo extends Unit_Medieval{
    public final int COSTO = 60;
    public final int MATPRIMA = 0;
    public final int MANUTEN = 1;

    public Unit_Esclavo(){
        super("Esclavo", 50, 0, 0, 0, 0);
    }
    public ImageIcon getIcon(){
        return null;
    }
    public void hacerAccion(Reino r){
    }
}
