import javax.swing.*;

public class Unit_Portaaviones extends Unit_Contemporaneo{


    public Unit_Portaaviones(){
        super("Portaaviones", 750, 150, 20, 2, 0);
        terreno = 2;
        setPrecios(600, 150, 8);

    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images_unit/portaaviones.jpg"));
    }
    public void hacerAccion(Reino r){

    }
    public void setBalasEspeciales(){
        balasEspeciales = 10;
    }
}
