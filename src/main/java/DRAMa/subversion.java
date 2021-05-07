package DRAMa;

//����������� ����������
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //���������� ��� ������� ���������
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)
import Math.Accessory;
import Math.Calculations;
import Math.FrameColor;
import Math.FrameMaterial;
import Math.FrameType;
import Math.GlassUnit;
import Math.OpeningMechanism;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color;

//��������� �����
public class subversion {
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	
	Map<String, Double> promos = new HashMap<String, Double>();

	public subversion() {
		JFrame main_GUI = new JFrame("subversion"); // �������� ������������ ����
		main_GUI.setTitle("����������� ��������� ������������ ������� ����������� ��� �����. ���������");
		main_GUI.setBounds(350, 170, 620, 450);
		main_GUI.setResizable(false); // ������������� ������ ����
		main_GUI.setBackground(Color.black);
		final Image logo = new Image();
		final JPanel main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
		main_panel.setLayout(null);
		main_GUI.add(main_panel);

		//���� ��������������� ������ ����������� (user423)
		JLabel laba_info = new JLabel("�������� �������:"); // ����������� ������ ��� �����������
		laba_info.setBounds(15, 0, 150, 30);
		main_panel.add(laba_info);
		JLabel visota = new JLabel("������:"); // ����������� ������
		visota.setBounds(78, 27, 500, 30);
		main_panel.add(visota);
		JLabel shirina = new JLabel("������:"); // ����������� ������
		shirina.setBounds(78, 50, 500, 30);
		main_panel.add(shirina);
		JLabel cvet = new JLabel("���� �������:"); // ����������� ������
		cvet.setBounds(45, 87, 500, 30);
		main_panel.add(cvet);
		JLabel meh = new JLabel("�������� ����������:"); // ����������� ������
		meh.setBounds(15, 225, 500, 30);
		main_panel.add(meh);
		JLabel stvor1 = new JLabel("��� �������� 1 �������:"); // ����������� ������
		stvor1.setBounds(15, 255, 500, 30);
		main_panel.add(stvor1);
		JLabel stvor2 = new JLabel("��� �������� 2 �������:"); // ����������� ������
		stvor2.setBounds(15, 285, 500, 30);
		main_panel.add(stvor2);
		JLabel stvor3 = new JLabel("��� �������� 3 �������:"); // ����������� ������
		stvor3.setBounds(15, 315, 500, 30);
		main_panel.add(stvor3);
		JLabel aks = new JLabel("����������:"); // ����������� ������
		aks.setBounds(48, 175, 500, 30);
		main_panel.add(aks);
		JLabel izd = new JLabel("�������� �������:"); // ����������� ������
		izd.setBounds(15, 115, 500, 30);
		main_panel.add(izd);
		JLabel steklo = new JLabel("�����������:"); // ����������� ������
		steklo.setBounds(48, 145, 500, 30);
		main_panel.add(steklo);
		JLabel promokod = new JLabel("��������:"); // ����������� ������
		promokod.setBounds(410, 315, 500, 30);
		main_panel.add(promokod);

		final JTextArea heightTextArea = new JTextArea("500"); // ���� ��� ����� ������
		heightTextArea.setBounds(130, 34, 50, 20);
		main_panel.add(heightTextArea);
		final JTextArea widthTextArea = new JTextArea("500"); // ���� ��� ����� ������
		widthTextArea.setBounds(130, 58, 50, 20);
		main_panel.add(widthTextArea);
		final JTextArea promoTextArea = new JTextArea(""); // ���� ��� ����� ���������
		promoTextArea.setBounds(480, 320, 110, 20);
		main_panel.add(promoTextArea);
		
		JButton button_exit = new JButton("�����"); // ��������� ������ �� ����
		button_exit.setBounds(170, 365, 100, 40);
		button_exit.setForeground(Color.black);
		ActionListener actionListener = new ListenerButton(); // ������� ���������
		button_exit.addActionListener(actionListener); // ��������� ��������� � ������
		main_panel.add(button_exit);
		JButton button_info = new JButton("�� �������"); // ������ ������ ����������
		button_info.setBounds(470, 365, 120, 40);
		button_info.setForeground(Color.black);
		ActionListener act = new InfoButton();
		button_info.addActionListener(act);
		main_panel.add(button_info);
		JButton button_cost = new JButton("������ ���������"); // ������ ������ �������
		button_cost.setBounds(10, 365, 140, 40);
		button_cost.setForeground(Color.black);
		main_panel.add(button_cost);

		String[] open1 = { // ���������� �������
				"������", "��������", "����������", "���������-��������" };
		final JComboBox<Object> type = new JComboBox<Object>(open1); // ���������� ������� ����������
		String[] open2 = { // ���������� �������
				"������", "��������", "����������", "���������-��������" };
		final JComboBox<Object> type2 = new JComboBox<Object>(open2); // ���������� ������� ����������
		String[] open3 = { // ���������� �������
				"������", "��������", "����������", "���������-��������" };
		final JComboBox<Object> type3 = new JComboBox<Object>(open3); // ���������� ������� ����������
		String[] transfer = { // ���������� �������
				"��������������", "��������������", "�������������", "�������������� � ��������", "������������� � ��������" };
		final JComboBox<Object> dram = new JComboBox<Object>(transfer); // ���������� ������� ����������
		ActionListener dramaTransfer = new ActionListener() { // �������� ���������
			
			public void actionPerformed(ActionEvent e) {
				String choice = (String) dram.getSelectedItem();
				logo.loadImage(choice);
				logo.setSize(500, 500);
				logo.setLocation(320, 10); // ����������� ���������� �����������
				main_panel.remove(logo);
				main_panel.add(logo);
				main_panel.setVisible(false);
				main_panel.setVisible(true);

				if (choice == "��������������") {
					type.setEnabled(true);
					type2.setEnabled(false);
					type3.setEnabled(false);
				} else if (choice == "��������������" || choice == "�������������� � ��������") {
					type.setEnabled(true);
					type2.setEnabled(true);
					type3.setEnabled(false);
				} else {
					type.setEnabled(true);
					type2.setEnabled(true);
					type3.setEnabled(true);
				}
			}
		};
		
		dram.addActionListener(dramaTransfer); // ���������� ��������� � ����������
		dram.setBounds(130, 7, 170, 20); // ����������� �������� ���� combobox
		main_panel.add(dram); // ���������� combobox �� ������
		String choice = transfer[0];
		logo.loadImage(choice);
		logo.setSize(500, 500);
		logo.setLocation(320, 10); // ����������� ���������� �����������
		main_panel.remove(logo);
		main_panel.add(logo);
		main_panel.setVisible(false);
		main_panel.setVisible(true);

		String[] color1 = { // ���������� �������
				"����������", "�������" };
		final JComboBox<Object> svet = new JComboBox<Object>(color1); // ���������� ������� ����������
		ActionListener svetColor1 = new ActionListener() { // �������� ���������

			public void actionPerformed(ActionEvent e) {
			}
		};

		svet.addActionListener(svetColor1); // ���������� ��������� � ����������
		svet.setBounds(130, 94, 170, 20); // ����������� �������� ���� combobox
		main_panel.add(svet); // ���������� combobox �� ������

		ActionListener typeOpen1 = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
			}
		};
		type.addActionListener(typeOpen1); // ���������� ��������� � ����������
		type.setBounds(160, 260, 140, 20); // ����������� �������� ���� combobox
		main_panel.add(type); // ���������� combobox �� ������

		ActionListener type2Open2 = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
			}
		};
		type2.addActionListener(type2Open2); // ���������� ��������� � ����������
		type2.setBounds(160, 290, 140, 20); // ����������� �������� ���� combobox
		main_panel.add(type2); // ���������� combobox �� ������

		ActionListener type3Open3 = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
			}
		};
		type3.addActionListener(type3Open3); // ���������� ��������� � ����������
		type3.setBounds(160, 320, 140, 20); // ����������� �������� ���� combobox
		main_panel.add(type3); // ���������� combobox �� ������

		String[] akses = { // ���������� �������
				"����������", "������", "���������� � ������" };

		final JComboBox<Object> dop = new JComboBox<Object>(akses); // ���������� ������� ����������
		ActionListener dopAkses = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
			}
		};
		dop.addActionListener(dopAkses); // ���������� ��������� � ����������
		dop.setBounds(130, 180, 170, 20); // ����������� �������� ���� combobox
		main_panel.add(dop); // ���������� combobox �� ������

		String[] izdel = { // ���������� �������
				"���", "������", "������" };
		final JComboBox<Object> material = new JComboBox<Object>(izdel); // ���������� ������� ����������
		ActionListener materialIzdel = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
			}
		};
		material.addActionListener(materialIzdel); // ���������� ��������� � ����������
		material.setBounds(130, 122, 170, 20); // ����������� �������� ���� combobox
		main_panel.add(material); // ���������� combobox �� ������

		String[] kamer = { // ���������� �������
				"������������", "�����������" };
		final JComboBox<Object> kolvo = new JComboBox<Object>(kamer); // ���������� ������� ����������
		ActionListener kolvoKamer = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
			}
		};
		kolvo.addActionListener(kolvoKamer); // ���������� ��������� � ����������
		kolvo.setBounds(130, 150, 170, 20); // ����������� �������� ���� combobox
		main_panel.add(kolvo); // ���������� combobox �� ������
		main_GUI.setVisible(true);
		main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener price = new ActionListener() { // �������� ���������
			public void actionPerformed(ActionEvent e) {
				// �������� �� ���� ������������ �������� � ����� ������ ������������ 
				int height, width;
				try {
				height = Integer.parseInt(heightTextArea.getText());
				width = Integer.parseInt(widthTextArea.getText());
				} catch (Exception error) {
				System.out.print("������� ���������� ������� �������");
				JOptionPane.showMessageDialog(null, "������� ���������� ������� �������!\n "
				+ "\n����������� �������� ������: 500 ��\n������������ �������� ������: 1800 ��"
				+ "\n����������� �������� ������: 500 ��\n������������ �������� ������: 3000 ��");
				}
				// �������� �� ���� ����������� � ����� ������ ������������ 
				height = Integer.parseInt(heightTextArea.getText());
				width = Integer.parseInt(widthTextArea.getText());
				if (height > 1800 || height < 500 || width > 3000 || width < 500) {
				System.out.print("������� ���������� ������� �������");
				JOptionPane.showMessageDialog(null, "������� ���������� ������� �������!\n "
				+ "\n����������� �������� ������: 500 ��\n������������ �������� ������: 1800 ��"
				+ "\n����������� �������� ������: 500 ��\n������������ �������� ������: 3000 ��");
				return;
				}
				// ������� ���������� �������� � ����� ��� ����������� �������
				FrameColor frameColor = FrameColor.fromString(svet.getSelectedItem().toString());
				GlassUnit glassUnit = GlassUnit.fromString(kolvo.getSelectedItem().toString());
				Accessory accessory = Accessory.fromString(dop.getSelectedItem().toString());
				FrameType frametype = FrameType.fromString(dram.getSelectedItem().toString());
				FrameMaterial frameMaterial = FrameMaterial.fromString(material.getSelectedItem().toString());
				OpeningMechanism first = OpeningMechanism.fromString(type.getSelectedItem().toString());
				OpeningMechanism second = OpeningMechanism.fromString(type2.getSelectedItem().toString());
				OpeningMechanism third = OpeningMechanism.fromString(type3.getSelectedItem().toString());
				
				Double discountValue = promos.get(promoTextArea.getText());
				double discount = discountValue == null ? 1 : discountValue;
				// ��� ������� ������������ �������� �����������
				if (frametype == null) {
					return;
				}
				// ����������� �������� �� �����������
				if (frameMaterial == null) {
					return;
				}
				List<OpeningMechanism> mechanisms = new ArrayList<OpeningMechanism>();
				if (frametype == FrameType.SINGLELEAF) {
					if (first == null) {
						return;
					}
					mechanisms.add(first);
				} else if (frametype == FrameType.BIVALVE || frametype == FrameType.BIVALVETRANSOM) {
					if (first == null || second == null) {
						return;
					}
					mechanisms.add(first);
					mechanisms.add(second);
				} else {
					if (first == null || second == null || third == null) {
						return;
					}
					mechanisms.add(first);
					mechanisms.add(second);
					mechanisms.add(third);
				}
				if (frameColor == null) {
					return;
				}
				if (glassUnit == null) {
					return;
				}
				if (accessory == null) {
					return;
				}
				
				double frameCost = Calculations.getWindowFrameCost(height, width, frametype, frameMaterial);
				double leafescost = Calculations.getLeafCost(mechanisms);
				double glassCost = Calculations.getGlassUnitCost(height, width, glassUnit);
				double accCost = Calculations.getAccessoriesCost(width, accessory);
				double fullCost = Calculations.getResultSum(frameCost, leafescost, glassCost, accCost, frameColor, discount);
				System.out.println(fullCost);
				
				final JFrame main_GUI = new JFrame(); // �������� ������ ����
				main_GUI.setTitle("������ ���������"); 
				main_GUI.setBounds(400, 400, 300, 120);
				main_GUI.setResizable(false); 
				JPanel resultPanel = new JPanel();
				main_panel.setLayout(null);
				main_GUI.add(resultPanel);
				JLabel moder = new JLabel("�������� ��������� �������� " + fullCost + "�"); // ���������� �������
				moder.setBounds(40, 10, 500, 40);
	
				JButton button_back = new JButton("�������"); // ���������� ������ "�������"
				button_back.setBounds(370, 150, 100, 40); // ������ � ������������ ������ "�������"
				button_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						main_GUI.dispose(); // ���������� �������� ���� �������
					}
				});
				resultPanel.add(moder);
				resultPanel.add(button_back);
				main_GUI.setVisible(true);
				main_GUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		};
		button_cost.addActionListener(price);
		
		promos.put("drama_5", 0.95); // ���� ��������� �� 5%
		promos.put("drama_10", 0.9); // ���� ��������� �� 10%
		
		type.setSelectedIndex(0);
		type2.setSelectedIndex(0);
		type3.setSelectedIndex(0);
		dram.setSelectedIndex(0);
		svet.setSelectedIndex(0);
		material.setSelectedIndex(0);
		kolvo.setSelectedIndex(0);
		dop.setSelectedIndex(0);
	}
		
		// �������� ���� JFrame � �������� Java
		public static void main(String[] args) {
			new subversion();
		}

		public int fullCost() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int frameCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	}