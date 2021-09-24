package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categorias;
import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JTextField txtEstado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 198, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(96, 31, 96, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id. Producto :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(96, 99, 96, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 103, 102, 14);
		contentPane.add(lblCategora);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setBounds(324, 62, 89, 21);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(324, 93, 89, 21);
		contentPane.add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(324, 124, 89, 21);
		contentPane.add(btnListar);
		
		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1.setBounds(10, 57, 76, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(10, 80, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(10, 127, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setBounds(10, 150, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(96, 54, 96, 19);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(96, 77, 96, 19);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(96, 125, 96, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setText("0");
		txtEstado.setEditable(false);
		txtEstado.setEnabled(false);
		txtEstado.setBounds(96, 147, 96, 19);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		llenaCategoria();
	}

	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
	EntityManager em=fabrica.createEntityManager();
	
	void registrar() {
		String id=leerId();
		String descripcion=leerDescripcion();
		int stock=leerStock();
		int categoria=leerCategoria();
		double precio=leerPrecio();
		
		Producto p=new Producto();
		p.setIdprod(id);
		p.setDescripcion(descripcion);
		p.setStock(stock);
		p.setCategoria(categoria);
		p.setPrecio(precio);
		p.setEstado(Integer.parseInt(txtEstado.getText()));
		
		Producto idp = em.find(Producto.class, id);
		
		
		if(idp!=null) {
			aviso("Ya existe el codigo");
		} else {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}
	}
	
	private void aviso(String string) {
		JOptionPane.showMessageDialog(this, string);
	}

	private int leerCategoria() {
		return cboCategorias.getSelectedIndex();
	}

	private double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	private int leerStock() {
		return Integer.parseInt(txtStock.getText());
	}

	private String leerDescripcion() {
		return txtDescripcion.getText();
	}

	private String leerId() {
		return txtCódigo.getText();
	}
	
	private void llenaCategoria() {
		String sql="select c from Categorias c";
		
		List<Categorias> lstCategorias=em.createQuery(sql,Categorias.class).getResultList();
		System.out.println("Cantidad de productos " + lstCategorias.size());
		
		for(Categorias c:lstCategorias) {
			cboCategorias.addItem(c.getCategoria());
		}
		
	}
}
