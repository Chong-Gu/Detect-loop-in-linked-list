package linked_list;

public class detect_loop {
	public static void main(String[] args) {
		//Create a linked list which has a loop;
		//a->b->c->d->e->f
		//	 	|		 |
		//		j<-i<-h<-g
		Node root1 = new Node('a');
		Node curr = root1;
		
		for (int i = 0; i < 'j' - 'a'; i++) {
			char c = (char)('a' + i + 1);
			Node next = new Node(c);
			curr.next = next;
			curr = curr.next;
		}
		
//		System.out.println(curr.val);
//		curr = root1;
//		while(curr != null) {
//			System.out.println(curr.val);
//			curr = curr.next;
//		}
		if (detectLoop(root1))
			System.out.println("Detect a Loop!");
		else
			System.out.println("No Loop!");
		
		Node loopStart = root1.next.next;
		curr.next = loopStart;
		
		if (detectLoop(root1))
			System.out.println("Detect a Loop!");
		else
			System.out.println("No Loop!");
	}
	
	private static boolean detectLoop(Node head) {
		Node p = head;
		Node q = head;
		
		while (p!=null && q!=null && q.next!= null) {
			p = p.next;
			q = q.next.next;
			
			if (p == q) 
				return true;
		}
		
		return false;
	}
}
