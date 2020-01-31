package list;

import java.util.HashSet;

public class SingleLink {

	public static void printList(ListNode head) {
		ListNode ptr = head;
		while(ptr != null) {
			System.out.print(ptr.data + " -> " );
			ptr = ptr.next;
		}
		System.out.println("null");
	}
	
	
	//to push a node
	public static ListNode push(ListNode head, int data) {
		ListNode newNode = new ListNode();
		newNode.data = data;
		
		newNode.next = head;
		return newNode;
	}
	
	//function for linked list imp for given set of keys
	public static ListNode constructList(int[] keys) {
		ListNode head = null;
		
		//start at end of array
		for(int i = keys.length - 1; i >= 0; i--) {
			head = push(head, keys[i]);
		}
		return head;
	}
	
	//detect loop in linked list
	static boolean detectLoop(ListNode node) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		
		while(node != null) {
			if(set.contains(node)) {
				return true;
			}
		set.add(node);
		
		node = node.next;
		
		}
		
		return false;
		
		//create loop to test:
		
	}
	
	
	
	public static void main(String[] args) {
		int[] keys = {1,2,3,4,5,3};
		SingleLink slink = new SingleLink();
		
		//create loop to test:
		//slink.head.next.next.next = slink.head;
		ListNode head = constructList(keys);
		System.out.println(detectLoop(head));
		printList(head);
	}
}
