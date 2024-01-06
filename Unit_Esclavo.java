import javax.swing.*;

public class Unit_Esclavo extends Unit_Medieval{
    public final int COSTO = 60;
    public final int MATPRIMA = 0;
    public final int MANUTEN = 1;

    public Unit_Esclavo(){
        super("Esclavo", 50, 0, 0, 0, 0);
        setPrecios(30, 0, 1);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/esclavo.jpg"));
    }
    public void hacerAccion(Reino r){
    }
}
