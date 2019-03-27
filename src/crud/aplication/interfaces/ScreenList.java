package crud.aplication.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import crud.dao.ContatoDAO;
import crud.entities.Contato;
import javax.swing.JList;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ScreenList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenList frame = new ScreenList();
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
	public ScreenList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();

		table.setBounds(10, 11, 425, 349);
		contentPane.add(table);
		final DefaultTableModel modelo = new DefaultTableModel();

		JButton btnNewButton = new JButton("Apagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(253, 452, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenMain telaPrincipal = new ScreenMain();
				telaPrincipal.show();
				dispose();

			}
		});

		btnNewButton_1.setBounds(162, 452, 89, 23);
		contentPane.add(btnNewButton_1);

		button = new JButton("Listar*PROV");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ContatoDAO cttDAO = new ContatoDAO();
				Contato contato = new Contato();

				try {
					for (Contato c : cttDAO.listarTodos()) {

						System.out.println("ID: " + c.getId_contato() + " NOME: " + c.getNome() + " CPF: " + c.getCpf()
								+ " IDADE: " + c.getIdade() + " SEXO: " + c.getSexo());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(344, 452, 89, 23);
		contentPane.add(button);
	}

}
