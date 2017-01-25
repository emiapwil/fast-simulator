package org.fast.tdst;

import java.util.LinkedList;
import java.util.List;

public class TDST {

	// including data id and attribute id
	String xid;
	
	TDSTNode rootNode;
	
	List<LNode> leafNodes = new LinkedList<LNode>();
	
	public TDST(String xid) {
		this.xid = xid;
	}
	
	//return the first infected lnode
	public LNode findFirstInfectedLNode(DataChange dc) {
		if (rootNode instanceof LNode) {
			LNode lNode = (LNode) rootNode;
			if (lNode.isInfected(dc)) return lNode;
			else return null;
		} else {
			INode iNode = (INode) rootNode;
			return iNode.getFirstInfectedLNode(dc);
		}
	}
	
	// input is the earliest infected lnode in the original lnode list
	public static int ComputeNewState(LNode theEarliestLNode, DataChange dc) {
		return theEarliestLNode.getX() + dc.getDelta();
	}
	
	private void removeLNodeFromLeafNodes(LNode lNode) {
		for (LNode l: this.leafNodes) {
			if (l.getID() == lNode.getID()) {
				this.leafNodes.remove(l);
			}
		}
	}
		
	public void deleteLNode(LNode lNode) {
		if (rootNode == null) {
			return;
		}
		if (rootNode instanceof LNode) {
			LNode rootLNode = (LNode) rootNode;
			if (rootLNode.getID() == lNode.getD()) {
				rootNode = null;
			}
		} else {
			INode rootINode = (INode) rootNode;
			INode newRootINode = rootINode.deleteLNode(lNode);
			this.rootNode = newRootINode;
		}
		removeLNodeFromLeafNodes(lNode);
	}
	
	public void insertLNodeFromStart(LNode lNode) {
		if (rootNode == null) {
			rootNode = lNode;
			this.leafNodes.add(0, lNode);
			return;
		}
		
		LNode firstLNode = leafNodes.get(0);
		INode iNode = firstLNode.getFatherNode();
		INode newINode = iNode.insertNode(lNode);
		if (newINode != null) this.rootNode = newINode;
		this.leafNodes.add(0, lNode);
	}
	
	public void insertLNode(LNode lNode) {
		if (rootNode == null) {
			rootNode = lNode;
			this.leafNodes.add(lNode);
			return;
		}
		
		LNode lastLNode = leafNodes.get(leafNodes.size() - 1);
		INode iNode = lastLNode.getFatherNode();
		INode newINode = iNode.insertNode(lNode);
		if (newINode != null) this.rootNode = newINode;
		this.leafNodes.add(lNode);
	}
}
