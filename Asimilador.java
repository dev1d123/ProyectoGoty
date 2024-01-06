import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Asimilador extends Buildings{
    public Asimilador(){
        super("Asimilador", 200);
    }

    public ArrayList<String> getHabilidades(){
        return acciones;
    }
    public ImageIcon getIcon(){
        return new ImageIcon(getClass().getResource("images/asimilador.jpeg"));
    }
    public final int RECURSOS_GENERADOS=50;
    //Necesitar hacer clic para recolectar...recursos
    public void hacerAccion(Reino r){
        int ans = 0;
        for(Buildings b: r.getEdificios()){
            if(b instanceof Granjas){
                ans+=((Asimilador) b).RECURSOS_GENERADOS;
            }
        }
        //r.addRecursos(ans);
        JOptionPane.showMessageDialog(null, "Se añadio " + ans + " recursos de todos los asimiladores");

    }
}