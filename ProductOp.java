class ProductOp extends Branch {
	
	String operation = "";
	
	ProductOp(String o, Node rc, Node lc) {
		super(0, lc, rc);
		if (o.startsWith("/"))
			operation = "/";
		else
			operation = "*";
	}

	int calcVal() {
		if (operation.startsWith("*")) {
			int lcval = leftChild.calcVal();
			int rcval =  rightChild.calcVal();
			int val = lcval * rcval;
			System.out.println(lcval + " * " + rcval + " = " + val);
			return val;
		} else {
			int lcval = leftChild.calcVal();
			int rcval =  rightChild.calcVal();
			int val = lcval / rcval;
			System.out.println(lcval + " / " + rcval + " = " + val);
			return val;
		}	
	}
	
	void show(String prefix, String indent) {
		System.out.println(this + ": " + prefix  + indent + operation);
		leftChild.show(prefix + "L", indent + "   ");
		rightChild.show(prefix + "R", indent + "   ");
	}
}