
package hackathon7;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.LinkedList;

/**
 *
 * @author Maribel
 */
public class Hackathon7 extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private Image dbImage; // Imagen a proyectar.
    private Graphics dbg; // Objeto grafico
    private Personaje principal;
   
    private long tiempoActual; //Variables de control de tiempo de la animacion
    private int tiempoCaida;
    private int posYinicial;
    private Obstaculos obs1;
    private Obstaculos obs2;
    private Obstaculos obs3;
    private Obstaculos obs4;
    private Obstaculos obs5;
    private Obstaculos obs6;
    private LinkedList<Obstaculos> listaAbajo; //Lista para guardar los bloques 
    private LinkedList<Obstaculos> listaArriba; //Lista para guardar los bloques 

    public Hackathon7() {
       
        setTitle("24H");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        this.setSize(800, 600); //tamaño del jframe
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    
        principal = new Personaje(100, 100);
        principal.setPosY(getHeight()-principal.getAlto());

        obs1 = new Obstaculos(800, 800);
        obs2 = new Obstaculos(950, 800);
        obs3 = new Obstaculos (1100, 800);
        
        obs4 = new Obstaculos(800, 0);
        obs5 = new Obstaculos(1000, 0);
        obs6 = new Obstaculos (1300, 0);
        
        listaAbajo = new LinkedList();
        listaArriba = new LinkedList();
        
        Image freezer1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenesObst/tube.png"));
        obs1.getAnima().sumaCuadro(freezer1, 300);
        Image freezer2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenesObst/tube.png"));
        obs2.getAnima().sumaCuadro(freezer2,300);
        Image freezer3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenesObst/tube.png"));
        obs3.getAnima().sumaCuadro(freezer3,300);
        
        Image freezer4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenesObst/tube.png"));
        obs4.getAnima().sumaCuadro(freezer4, 300);
        Image freezer5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenesObst/tube.png"));
        obs5.getAnima().sumaCuadro(freezer5,300);
        Image freezer6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenesObst/tube.png"));
        obs6.getAnima().sumaCuadro(freezer6,300);
        
        obs1.setPosY(600 - obs1.getAlto());
        obs2.setPosY(600 - obs2.getAlto());
        obs3.setPosY(600 - obs3.getAlto());
        
        obs4.setPosY(0 + obs4.getAlto());
        obs5.setPosY(0 + obs5.getAlto());
        obs6.setPosY(0 + obs6.getAlto());
        
        listaAbajo.add(obs1);
        listaAbajo.add(obs2);
        listaAbajo.add(obs3);
        
        listaArriba.add(obs4);
        listaArriba.add(obs5);
        listaArriba.add(obs6);
        
        
        posYinicial = principal.getPosY();
        tiempoCaida = 0;
            // Declaras un hilo
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }

    public void stop() {

    }

    public void destroy() {

    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {
        //Guarda el tiempo actual del sistema
        tiempoActual = System.currentTimeMillis();

        while (true) {
            actualiza();
            checaColision();
            repaint();
            try {
                // El thread se duerme.
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }

    }

    /**
         * Metodo usado para actualizar la posicion de objetos y actualizar el
         * tiempo de los frames
         */
    public void actualiza() {
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;
        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;
        //obs1.setPosX(obs1.getPosX() - 15);
        principal.actualiza(tiempoActual);
        
       // if(obs1.getPosX() <= 0){
        //    obs1.setPosX(700);
        //}
        for (int i = 0; i < listaAbajo.size(); i++) {
            if (((Obstaculos) listaAbajo.get(i)).getPosX() <= 0) {
  
                ((Obstaculos) listaAbajo.get(i)).setPosX(900);
               
            }
            ((Obstaculos) listaAbajo.get(i)).setPosX(listaAbajo.get(i).getPosX() - 15);
        }
        
           for (int i = 0; i < listaArriba.size(); i++) {
            if (((Obstaculos) listaArriba.get(i)).getPosX() <= 0) {
  
                ((Obstaculos) listaArriba.get(i)).setPosX(900);
               
            }
            ((Obstaculos) listaArriba.get(i)).setPosX(listaArriba.get(i).getPosX() - 15);
        }
        
        //Salto del personaje principal
        tiempoCaida++;
        if (principal.getSalta()){
           // tiempoCaida = 0;
            principal.setVelocidad(20);
            int aux = (principal.getVelocidad() * tiempoCaida) - (4 * tiempoCaida * tiempoCaida) / 2;
            principal.setPosY(principal.getPosY() - aux);
            
        }
        
    }

    public void checaColision() {
         //Checa colision del principal con el fondo del JFrame
        if ( (principal.getSalta()) && ( principal.getPosY() > getHeight()) ){
            principal.setSalta();
            principal.setVelocidad(0);
            principal.setPosY(posYinicial);
        }
    }

    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && !principal.getSalta()){
            principal.setSalta();
            tiempoCaida = 0;
        }
    }

    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al dar click con el mouse.
     *
     * @param e es el <code>evento</code> que se genera al presionar el mouse.
     */
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Metodo <I>moseEntered</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera entrar en un componente.
     *
     * @param e es el <code>evento</code> que se genera al entrar en un
     * componenete.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Metodo <I>moseExited</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al salir de un componenete
     *
     * @param e es el <code>evento</code> que se genera al presionar el mouse.
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al mover el mouse.
     *
     * @param e es el <code>evento</code> que se genera al mouse el mouse.
     */

    public void mouseMoved(MouseEvent e) {
    }

    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar el mouse
     *
     * @param e es el <code>evento</code> que se genera al presionar el mouse.
     */
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar el click del
     * mouse.
     *
     * @param e es el <code>evento</code> que se genera al soltar el click del
     * mouse
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al mover el mouse mientras
     * esta cicleado
     *
     * @param e es el <code>evento</code> que se genera al mover el mouse
     * mientras esta cicleado
     */
    public void mouseDragged(MouseEvent e) {
    }

    public void paint(Graphics g) {

        // Inicializan el DoubleBuffer
        if (dbImage == null) {

            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }
        // Actualiza la imagen de fondo
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
        // Actualiza el Foreground
        dbg.setColor(getForeground());
        paint1(dbg);
        // Dibuja la imagen actualizada y con esto ya no se ve parpadeo
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paint1(Graphics g) {
        g.setColor(Color.YELLOW);
        g.setFont(new Font("default", Font.BOLD, 20));
        
        g.drawImage(principal.getImagenI(), principal.getPosX(), principal.getPosY(),this);
        g.drawImage(obs1.getImagenI(),obs1.getPosX(), obs1.getPosY(),this);
         for(int i = 0; i < listaAbajo.size(); i++){
             g.drawImage(listaAbajo.get(i).getImagenI(), listaAbajo.get(i).getPosX(),listaAbajo.get(i).getPosY(), this);
        }
          for(int i = 0; i < listaArriba.size(); i++){
             g.drawImage(listaArriba.get(i).getImagenI(), listaArriba.get(i).getPosX(),listaArriba.get(i).getPosY(), this);
        }
      
    }

}

