package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa, BorderLayout.CENTER );
    }

    @Override
  
    public void paint(Graphics g)
    {
        super.paint(g);

        if (restaurantes == null || restaurantes.isEmpty()) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        // Ajusta estos valores según el tamaño de cada celda en tu mapa
        int anchoCelda = 50;
        int altoCelda = 50;

        for (Restaurante restaurante : restaurantes)
        {
            int fila = restaurante.getFila();
            int columna = restaurante.getColumna();
            String nombre = restaurante.getNombre();

            // Calcula la posición en píxeles (ajustar si tu mapa tiene offsets)
            int x = columna * anchoCelda + 10; // offset horizontal
            int y = fila * altoCelda + 30;     // offset vertical

            // Dibuja un punto o círculo y el nombre del restaurante
            g2d.fillOval(x, y, 10, 10); // Marca del restaurante
            g2d.drawString(nombre, x + 12, y + 10); // Nombre al lado de la marca
        }
    }

    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}
