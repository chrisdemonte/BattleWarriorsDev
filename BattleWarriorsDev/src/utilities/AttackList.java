package utilities;

import java.util.ArrayList;

import attacks.Move;

public class AttackList {
	
	ArrayList<Move> moveList;
	int size;
	int elms;
	
	public AttackList() {
		this.moveList = new ArrayList<Move>();
		this.size = 0;
		this.elms = 0;
	}

	public ArrayList<Move> getMoveList() {
		return moveList;
	}

	public void setMoveList(ArrayList<Move> moveList) {
		this.moveList = moveList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getElms() {
		return elms;
	}

	public void setElms(int elms) {
		this.elms = elms;
	}
	
	

}
