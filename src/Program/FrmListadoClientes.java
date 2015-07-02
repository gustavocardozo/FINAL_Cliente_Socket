package Program;

import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;

public class FrmListadoClientes extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected JTable tabla;
	
	public FrmListadoClientes(List<Cliente> clientes)  {
		// TODO Auto-generated constructor stub
		panel = new JPanel();
		
		
		
		getContentPane().add(panel);
		panel.setLayout(null);
		setBounds(50, 50, 800, 600);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		//columnas
		modelo.addColumn("ID_CLIENTE");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("EMAIL");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("FEC_NACIMIENTO");
		//recorro la tabla
		for(Cliente clie : clientes){
			Object[] fila = new Object[8];
			fila[0] = clie.getId();
			fila[1] = clie.getDireccion();
			fila[2] = clie.getEmail();
			fila[3] = clie.getTelefono();
			fila[4] = clie.getDni();
			fila[5] = clie.getNombre();
			fila[6] = clie.getApellido();
			fila[7] = clie.getFecha_nacimiento();
			modelo.addRow(fila);
		}
		tabla = new JTable(modelo);
		tabla.setBounds(10,10, 750, 500);
		
		//agrego todos los elementos al frame
		
		panel.add(tabla);
		
	}

}
