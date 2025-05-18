package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        setLayout(new GridLayout(3, 2, 5, 5)); // Tres filas, dos columnas, con espacio entre componentes

        // Campo para el nombre con etiqueta
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        add(lblNombre);
        add(txtNombre);

        // Selector para la calificación con etiqueta
        JLabel lblCalificacion = new JLabel("Calificación:");
        cbbCalificacion = new JComboBox<>(new String[] { "1", "2", "3", "4", "5" });
        add(lblCalificacion);
        add(cbbCalificacion);

        // Selector para indicar si fue visitado con etiqueta
        JLabel lblVisitado = new JLabel("¿Visitado?");
        cbbVisitado = new JComboBox<>(new String[] { "Sí", "No" });
        add(lblVisitado);
        add(cbbVisitado);
    }

    public boolean getVisitado()
    {
        String seleccion = (String) cbbVisitado.getSelectedItem();
        return seleccion.equals("Sí");
    }

    public String getNombre()
    {
        return txtNombre.getText().trim();
    }

	

	public int getCalificacion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
