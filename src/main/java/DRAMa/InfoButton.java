package DRAMa;//����� Java �������

//����������� ����������
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//��������� �����
public class InfoButton implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		final JFrame main_GUI = new JFrame(); //
		main_GUI.setTitle("������������ �������");
		main_GUI.setBounds(400, 220, 500, 250);
		main_GUI.setResizable(false); // ������ ����

		JPanel main_panel = new JPanel();
		main_panel.setLayout(null);
		main_GUI.add(main_panel);

//���� ��������� ��������� ��������� � ���������
		JLabel moder = new JLabel("��������� ���������: ������� ����� ��������� - 19130633 ");
		moder.setBounds(40, 10, 500, 40);
		JLabel first = new JLabel("1-� �������� ���������: ��������� ������ �������� - 19130639");
		first.setBounds(40, 40, 500, 40);
		JLabel second = new JLabel("2-� �������� ���������: ������� ����� ���������� - 19130620");
		second.setBounds(40, 70, 500, 40);
		JLabel third = new JLabel("3-� �������� ���������: �������� ������ �������������� - 19130635");
		third.setBounds(40, 100, 500, 40);

//���� ��������� ������ "�����"
		JButton button_back = new JButton("�����");
		button_back.setBounds(370, 150, 100, 40); // ������ � ������������ ������ "�����" �� ���� ����������
		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_GUI.dispose(); // ���������� �������� ���� ����������
			}
		});

		main_panel.add(button_back);
		main_panel.add(moder);
		main_panel.add(first);
		main_panel.add(second);
		main_panel.add(third);
		main_GUI.setVisible(true);
		main_GUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}