package cn.itbaizhan.mine;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class MineGame extends JFrame implements ActionListener {
	JMenuBar bar;
	JMenu fileMenu1, fileMenu2;
	JMenuItem ����, �м�, �߼�, �Զ���, ɨ�װ�;
	JMenuItem ����, �淨;
	MineArea mineArea = null;
	File Ӣ�۰� = new File("Ӣ�۰�.txt");
	Hashtable hashtable = null;
	ShowRecord showHeroRecord = null;
	JDialog set = null;
	JPanel panel, panel1, panel2, panel3, panel4;
	JLabel label, label1, label2, label3;
	JTextField row = null, column = null, mine = null;
	JButton ȷ��,ȡ��;
	JDialog introduce = null, play = null;
	JLabel label4, label5;
	
	MineGame() {
		mineArea = new MineArea(16, 16, 40, 2);
		add(mineArea, BorderLayout.CENTER); // �߿򲼾�
		bar = new JMenuBar();
		fileMenu1 = new JMenu("��Ϸ");
		���� = new JMenuItem("����");
		�м� = new JMenuItem("�м�");
		�߼� = new JMenuItem("�߼�");
		�Զ��� = new JMenuItem("�Զ���");
		ɨ�װ� = new JMenuItem("ɨ�װ�");
		fileMenu1.add(����);
		fileMenu1.add(�м�);
		fileMenu1.add(�߼�);
		fileMenu1.add(�Զ���);
		fileMenu1.add(ɨ�װ�);
		fileMenu2 = new JMenu("����");
		���� = new JMenuItem("����");
		�淨 = new JMenuItem("�淨");
		fileMenu2.add(����);
		fileMenu2.add(�淨);
		bar.add(fileMenu1);
		bar.add(fileMenu2);
		setJMenuBar(bar); // ���ô���Ĳ˵���
		����.addActionListener(this);
		�м�.addActionListener(this);
		�߼�.addActionListener(this);
		�Զ���.addActionListener(this);
		ɨ�װ�.addActionListener(this);
		����.addActionListener(this);
		�淨.addActionListener(this);
		hashtable = new Hashtable();
		hashtable.put("����", "����#" + 999 + "#����");
		hashtable.put("�м�", "�м�#" + 999 + "#����");
		hashtable.put("�߼�", "�߼�#" + 999 + "#����");
		if (!Ӣ�۰�.exists()) {
			try {
				FileOutputStream out = new FileOutputStream(Ӣ�۰�);
				ObjectOutputStream objectOut = new ObjectOutputStream(out);
				objectOut.writeObject(hashtable);
				objectOut.close();
				out.close();
			} catch (IOException e) {
			}
		}
		showHeroRecord = new ShowRecord(this, hashtable);
		setBounds(300, 100, 480, 560); // �ƶ������������С
		setVisible(true); // ʹWindow�ɼ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ر�Window��ͬʱ�ر���Դ
		validate(); // �ٴβ��������
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ����) {
			mineArea.initMineArea(9, 9, 10, 1);
			setBounds(300, 100, 270, 350);
		}
		if (e.getSource() == �м�) {
			mineArea.initMineArea(16, 16, 40, 2);
			setBounds(300, 100, 480, 560);
		}
		if (e.getSource() == �߼�) {
			mineArea.initMineArea(16, 30, 99, 3);
			setBounds(100, 100, 900, 560);
		}
		if (e.getSource() == �Զ���) {
			set = new JDialog();
			set.setTitle("�Զ����Ѷ�");
			set.setBounds(300,100,300,130);
			set.setResizable(false);//���ô�С���ɱ�
			set.setModal(true);//����Ϊ�Ի���ģʽ
			panel = new JPanel();
			//panel.setLayout(new BorderLayout());
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			panel4 = new JPanel();
			label = new JLabel("���������������������", JLabel.CENTER); 
			label1 = new JLabel("�У�", JLabel.CENTER); 
			label2 = new JLabel("�У�", JLabel.CENTER); 
			label3 = new JLabel("��������", JLabel.CENTER); 
			row = new JTextField();
			row.setText("16");
			row.setSize(1, 6);
			column = new JTextField();
			column.setText("16");
			mine = new JTextField();
			mine.setText("40");
			ȷ�� = new JButton("ȷ��");
			ȷ��.addActionListener(this);
			ȡ�� = new JButton("ȡ��");
			ȡ��.addActionListener(this);
			panel1.add(label1);
			panel1.add(row);
			panel2.add(label2);
			panel2.add(column);
			panel3.add(label3);
			panel3.add(mine);
			panel4.add(ȷ��);
			panel4.add(ȡ��);
			panel.add(panel1);
			panel.add(panel2);
			panel.add(panel3);
			set.add(label, BorderLayout.NORTH);
			set.add(panel, BorderLayout.CENTER);
			set.add(panel4, BorderLayout.SOUTH);
			set.setVisible(true);
		}
		if (e.getSource() == ɨ�װ�) {
			if (showHeroRecord != null)
				showHeroRecord.setVisible(true);
		}
		if (e.getSource() == ȷ��) {
			int rowNum = Integer.parseInt(row.getText());
			int columnNum = Integer.parseInt(column.getText());
			int mineNum = Integer.parseInt(mine.getText());
			if(rowNum < 9)
				rowNum = 9;
			if(rowNum > 16)
				rowNum = 16;
			if(columnNum < 9)
				columnNum = 9;
			if(columnNum > 30)
				columnNum = 30;
			if(mineNum < 10)
				mineNum = 10;
			if(mineNum > 99)
				mineNum = 99;
			mineArea.initMineArea(rowNum, 
					columnNum, mineNum, 4);
			setBounds(100, 100, columnNum * 30, rowNum * 30 + 80);
			set.setVisible(false);
		}
		if (e.getSource() == ȡ��) {
			set.setVisible(false);
		}
		if (e.getSource() == ����) {
			introduce = new JDialog();
			introduce.setTitle("ɨ�׽���");
			introduce.setBounds(300,100,300,300);
			introduce.setResizable(false);
			introduce.setModal(true);
			label4 = new JLabel();
			label4.setSize(280, 250);
			label4.setText("<html><body>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspɨ����ԭʼ�İ汾����׷�ݵ�1973��"
					+ "һ����Ϊ�����顱����Ϸ�����ã������顱����д������Ϸ��Rlogic�����ڡ�Rlogic�����ҵ���������Ϊ����"
					+ "����½ս�Ӷ�Ա��Ϊָ������̽��һ��û�е��׵İ�ȫ·�ߣ����·ȫ�����׶��������䡣"
					+ "�������ķ������ɭ�ڡ�Rlogic���Ļ������ֱ�д������Ϸ�����ס����ɴ˵춨���ִ�ɨ����Ϸ�ĳ��Ρ�"
					+ "1981�꣬΢��˾���޲��ء��Ŷ��Ϳ��ء�Լ��ѷ��λ����ʦ��Windows3.1ϵͳ�ϼ����˸���Ϸ��"
					+ "ɨ����Ϸ����ʽ��ȫ�����ƹ㿪����</body></html>");
			introduce.add(label4);
			introduce.setVisible(true);
		}
		if (e.getSource() == �淨) {
			play = new JDialog();
			play.setTitle("��Ϸ�淨");
			play.setBounds(300,100,300,300);
			play.setResizable(false);
			play.setModal(true);
			label4 = new JLabel();
			label4.setSize(280, 250);
			label4.setText("<html><body>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspɨ��ϷĿ��������̵�ʱ����"
					+ "���ݵ�����ӳ��ֵ������ҳ����з��׸��ӣ�ͬʱ������ס�<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
					+ "&nbsp&nbsp����ҵ㿪һ������ʱ,���ڸø�������ʾ��Χ8�����ӵ�����"
					+ "�����û�������Զ��㿪��Χ�ĸ��ӣ��������Ҫͨ����Щ�������ж��׵�λ�ã�"
					+ "�����׵ĸ��ӱ��ΪС���졣�����е��ױ�����ҷ��׸��Ӷ����㿪ʱ��Ϸʤ����</body></html>");
			play.add(label4);
			play.setVisible(true);
		}
		validate();
	}

	public static void main(String args[]) {
		new MineGame();
	}
}
