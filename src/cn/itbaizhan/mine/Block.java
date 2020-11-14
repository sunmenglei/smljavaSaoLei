package cn.itbaizhan.mine;

import javax.swing.ImageIcon;

public class Block {
	String name; // ����,����"��"������
	int aroundMineNumber; // ��Χ�׵���Ŀ
	ImageIcon mineIcon; // �׵�ͼ��
	boolean isMine = false; // �Ƿ�����
	boolean isMark = false; // �Ƿ񱻱��
	boolean isOpen = false; // �Ƿ��ڿ�

	public Block() {
		super();
	}

	public Block(String name, int aroundMineNumber, ImageIcon mineIcon, boolean isMine, boolean isMark,
			boolean isOpen) {
		super();
		this.name = name;
		this.aroundMineNumber = aroundMineNumber;
		this.mineIcon = mineIcon;
		this.isMine = isMine;
		this.isMark = isMark;
		this.isOpen = isOpen;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAroundMineNumber(int n) {
		aroundMineNumber = n;
	}

	public int getAroundMineNumber() {
		return aroundMineNumber;
	}

	public void setMineIcon(ImageIcon icon) {
		mineIcon = icon;
	}

	public ImageIcon getMineicon() {
		return mineIcon;
	}

	public void setIsMine(boolean b) {
		isMine = b;
	}

	public boolean getIsMine() {
		return isMine;
	}

	public void setIsMark(boolean m) {
		isMark = m;
	}

	public boolean getIsMark() {
		return isMark;
	}

	public void setIsOpen(boolean p) {
		isOpen = p;
	}

	public boolean getIsOpen() {
		return isOpen;
	}

	@Override
	public String toString() {
		return "Block [name=" + name + ", aroundMineNumber=" + aroundMineNumber + ", mineIcon=" + mineIcon + ", isMine="
				+ isMine + ", isMark=" + isMark + ", isOpen=" + isOpen + "]";
	}
}
