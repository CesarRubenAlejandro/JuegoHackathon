/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Hackathon7 extends JFrame implements Runnable, KeyListener,MouseListener,MouseMotionListener{
    private static final long serialVersionUID = 1L;
    private Image dbImage; // Imagen a proyectar.
    private Graphics dbg; // Objeto grafico
     public Hackathon7() {
       
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
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
      
    }
    
    /**
     * Metodo usado para actualizar la posicion de objetos y actualizar el
     * tiempo de los frames
     */
    public void actualiza() {
  
    }
    
    public void checaColision(){
        
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

    }
     /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al dar click
     * con el mouse.
     *
     * @param e es el <code>evento</code> que se genera al presionar el mouse.
     */
    public void mouseClicked(MouseEvent e) {
        
       
    }
/**
     * Metodo <I>moseEntered</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera entrar
     * en un componente.
     *
     * @param e es el <code>evento</code> que se genera al entrar en un componenete.
     */
    public void mouseEntered(MouseEvent e) {
    }
    /**
     * Metodo <I>moseExited</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al salir de un
     * componenete
     *
     * @param e es el <code>evento</code> que se genera al presionar el mouse.
     */
    public void mouseExited(MouseEvent e) {
    }
    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al mover 
     * el mouse.
     *
     * @param e es el <code>evento</code> que se genera al mouse el mouse.
     */

    public void mouseMoved(MouseEvent e) {
    }
    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar 
     * el mouse
     * @param e es el <code>evento</code> que se genera al presionar el mouse.
     */
    public void mousePressed(MouseEvent e) {
       
    }
    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar el click
     * del mouse.
     *
     * @param e es el <code>evento</code> que se genera al soltar el click del mouse
     */
    public void mouseReleased(MouseEvent e) {
    }
    /**
     * Metodo <I>moseClicked</I> sobrescrito de la interface
     * <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al mover el mouse mientras esta 
     * cicleado
     * @param e es el <code>evento</code> que se genera al mover el mouse mientras esta 
     * cicleado
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
         g.setFont(new Font ("default", Font.BOLD, 20 ));
         //Imagen de fondo
       
    
    }

}
