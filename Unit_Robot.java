import javax.swing.*;

public class Unit_Robot extends Unit_Futurista{
    public final int COSTO = 100;
    public final int MATPRIMA = 5;
    public final int MANUTEN = 1;
    public Unit_Robot(){
        super("Robot", 5, 0, 0, 0, 0);
        setPrecios(100, 5, 1);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/robot.jpg"));
    }
    public void hacerAccion(Reino r){
    }
}
