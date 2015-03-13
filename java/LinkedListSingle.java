import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Node {

	private Node next;
	private int data;
	
	Node () {
		this.next = null;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return(this.data);
	}

	public Node getNextNode() {

		if(next != null){
			return next;
		}
		else {
			return null;
		}
	}
	
	public void setNextNode(Node nextNode) {
		this.next = nextNode;
	}
	
	public Node getLastNode() {
			
		Node temp = this;

		while ( temp.getNextNode() != null) {

			temp = temp.next;
		}
		return temp;
	}
	
	
}


public class LinkedListSingle extends Node{

	private Node list;
	private int listLength;


	LinkedListSingle () {
		list = new Node();
		listLength = 0;
	}
	
	public int addData(int data) {

		Node newNode = new Node();
		newNode.setData(data);
		Node temp = list.getLastNode();
		temp.setNextNode(newNode);
		this.listLength ++;
		return(1);

//		System.out.println("");
	}

	public void deleteNodeByData(int data) {
		Node previousNode = this.list;

		Node thisNode = previousNode.getNextNode();

		if (thisNode == null)
		{	
			System.out.println("List is Empty");
			return;
		}
		int deleteCount = 0;
		while(thisNode != null) {
//			System.out.println("test "+  thisNode.getData() + " " + data);
			Node nextNode = null;
			if (thisNode.getData() == data ) {
				nextNode = thisNode.getNextNode();
				previousNode.setNextNode(nextNode);
				this.listLength --;
				deleteCount ++;
				thisNode = nextNode;
				continue;
				}
				previousNode = previousNode.getNextNode();
				thisNode = thisNode.getNextNode();
//		System.out.println("Inside while " + thisNode.getData());
		}
		if ( deleteCount != 0) {
			System.out.println("Deletion Completed. Total Nodes deleted = "+ deleteCount);
		}
		else {
			System.out.println("No Match found");
		}
	
	}

	public void printList(){
		Node temp = list.getNextNode();
		if (temp == null) {
			System.out.println("List Empty");
			return;
		}
		System.out.println("\n\nDATA LIST");
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNextNode();
		}
		System.out.println("End\nList length = "+ listLength +"\nDone\n");
	}
	
	public static void main(String[] args) {

		LinkedListSingle testList = new LinkedListSingle();
		
		if  (args.length != 1)  {
				System.out.println("No input file to create a list. EXIT");
				System.exit(1);
			}
		else{
////////////
			String csvFile = args[0];
			BufferedReader inputstream = null;
			String line = "";
			String cvsSplitBy = ",";

			int data;
			int dataCount = 0;
			

			try {
 
				inputstream = new BufferedReader(new FileReader(csvFile));
				if((line = inputstream.readLine())!= null) {
					System.out.print("Singly linked list created");
				}
				while ((line = inputstream.readLine())!= null) {
 
			        // use comma as separator
					String[] values = line.split(cvsSplitBy);
	 				
					for (String s: values) {
						
						try {
					        data = Integer.parseInt(s);
					    } 
					    catch (NumberFormatException e) {
					        System.err.println("Argument" + s + " must be an integer.");
					        continue;
					    }
						testList.addData(data);
						dataCount ++;
					}
 				}
 			} catch (FileNotFoundException e) {
 				e.printStackTrace();
 			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputstream != null) {
					try {
						inputstream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

////////////
			System.out.print(" ---> Data added to the list  ---> Total data added = "+ dataCount);

			}
			
		
		int a = 1;
		
		while (a > 0) {
		
			System.out.println("\n| 1 : Add data | 2 : Delete Data | 3 : Print List | Enter you response |");
			Scanner in = new Scanner(System.in);
			a = in.nextInt();
	
			System.out.println("____________________________");

			if(a == 1) {

				System.out.println("Enter a number");
				
				int data = in.nextInt();

				if(testList.addData(data) == 1) {
					System.out.println("Data = " + data + " added successfully" );
				}
			}
			
			if(a == 2) {
				System.out.println("Enter a number");
				
				int data = in.nextInt();
			
				testList.deleteNodeByData(data);
			}

			if(a == 3) {
				testList.printList();
			}

			System.out.println("_________________________");
		}
	}
}