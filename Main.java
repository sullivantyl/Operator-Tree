/** driver for tree program */

class Main {
	public static void main(String[] args) {
		
		java.util.Scanner scn = new java.util.Scanner(System.in);

		Node t4a = new DataNode(3);
		Node t4b = new DataNode(8);
		Node t3b = new SubOp(t4a, t4b);
		Node t3a = new DataNode(2);
		Node t2a = new MultOp(t3a, t3b);

		Node t2b = new PlusOp(
				    new DataNode(11),
				    new DataNode(18));
		Node root = new SubOp(t2a, t2b);	

		System.out.println("init done, show");
		root.show("", "   ");
		while (true) {
			System.out.print("cmd: ");
			String cmd = scn.next();
			if ("find".startsWith(cmd)) {
				System.out.print("val? ");
				int val = scn.nextInt();
				Node found = root.find(val);

				if (found == null) {
					System.out.println(val + " not in tree");
				} else {
					System.out.println("Found " + val + ": " + found);
				}
			} else if ("show".startsWith(cmd)) {
				if (root == null)
					System.out.println("<null>");
				root.show("", "   ");
			}

			else if ("quit".startsWith(cmd)) {
				break;
			} else if ("calculate".startsWith(cmd)) {
				int val = root.calcVal();
				System.out.println(val);
			} else {
				System.out.println("unrec cmd " + cmd
						   + ", try: find  quit");
			}	
		}		
	}
}
