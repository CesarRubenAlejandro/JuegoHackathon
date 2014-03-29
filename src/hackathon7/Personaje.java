/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackathon7;
import java.awt.Image;
import java.awt.Toolkit;
/**
 *
 * @author Maribel
 */
public class Personaje extends Base {
   
    private boolean salta;
    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto raton.
     * @param posY es el <code>posiscion en y</code> del objeto raton.
     * @param image es la <code>imagen</code> del objeto raton.
     */

    public Personaje (int posX, int posY) {
        super(posX, posY);
        salta = false;

        Image freezer1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Personaje/frame_000.gif"));
        Image freezer2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Personaje/frame_001.gif"));
        Image freezer3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Personaje/frame_002.gif"));
        Image freezer4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Personaje/frame_003.gif"));
        anima = new Animacion();
        anima.sumaCuadro(freezer1, 300);
        anima.sumaCuadro(freezer2, 300);
        anima.sumaCuadro(freezer3, 300);
        anima.sumaCuadro(freezer4, 300);
       

    }
    
    public void setSalta(){
        salta = !salta;
    }
    public boolean getSalta(){
        return salta;
    }
}
