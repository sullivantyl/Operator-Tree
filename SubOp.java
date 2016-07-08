class SubOp extends Branch {
	
	String operation = "-";
	
	SubOp(Node rc, Node lc) {
		super(0, lc, rc);
	}
	
	int calcVal() {
		int lcval = leftChild.calcVal();
		int rcval =  rightChild.calcVal();
		int val = lcval - rcval;
		System.out.println(lcval + " " + operation + " " + rcval + " = " + val);
		return val;
	}
	
	void show(String prefix, String indent) {
		System.out.println(this + ": " + prefix  + indent + operation);
		leftChild.show(prefix + "L", indent + "   ");
		rightChild.show(prefix + "R", indent + "   ");
	}
}