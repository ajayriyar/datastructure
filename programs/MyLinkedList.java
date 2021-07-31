/*
[value,Node]--->[value,Node]--->[value, Node]
[123]   		[125]   	    [859]
*/

class Node<T>{
	private T value;
	private Node<T> node;
	
	public Node(T value, Node<T> node){
		this.value = value;
		this.node = node;
	}
	
	public void setNode(Node<T> node){
		this.node = node;
	}
	
	public Node<T> getNode(){
		return this.node;
	}
	
	public T getValue(){
		return this.value;
	}
}

class MyLinkedList<T> {
	private Node<T> head;
	private Node<T> currentNode;
	private int size;
	public void add(T value){
		if(head == null){
			head = new Node<>(value,currentNode);
		}else {
			Node<T> tempNode = new Node<>(value,null);
			if(head.getNode() == null){
				currentNode = tempNode;
				head.setNode(currentNode);
			}else{
				currentNode.setNode(tempNode);
				currentNode = tempNode;
			}
		}
	}
	
	public void traverse(){
		Node<T> tempNode;
		if(head.getNode() == null){
			size =1;
			System.out.println(head.getValue());
			return;
		}
		tempNode = head;
		while(tempNode != null){
			size++;
			System.out.println(tempNode.getValue());
			tempNode = tempNode.getNode();
		}
	}
	
	public int size(){
		size = 0;
		Node<T> tempNode;
		if(head.getNode() == null){
			size =1;
			return size;
		}
		tempNode = head;
		while(tempNode != null){
			size++;
			tempNode = tempNode.getNode();
		}
		return size;
	}
	
	public void deleteNIndexFromEnd(int index){
		size();
		if(this.size >= index)
			remove(this.size-index+1);
	}
	
	public void deleteNthIndexFromEnd(int index){
		 Node<T> first = head;
		 Node<T> second = head;
		 if(index > size()){
			return;
		 }
		 while(index > 0 && second != null){
			second = second.getNode();
			index--;
		 }
		 if(second == null){
			if(size() == 1){
				head = null;
			}else{
				head = head.getNode();
			}
		 }
		 
		 while(second.getNode() != null){
			second = second.getNode();
			first = first.getNode();
		 }
		 first.setNode(first.getNode().getNode());
	}
	
	/*
	* Remove a specific index
	*/
	
	public void remove(int index){
		int count =1; 
		if(index == 1){
			remove();
			return;
		}
		Node<T> temp = head;
		Node<T> prevNode = head;
		do{
			if(count == index){
				prevNode.setNode(temp.getNode());
			}
			prevNode = temp;
			temp = temp.getNode();
			count++;
		}while(temp != null);
	}
	
	/*
	* Remove the first element
	*/
	public void remove(){
		head = head.getNode();
	}
	
	public static void main(String args[]){
		MyLinkedList<String> list = new MyLinkedList<>();
		for(String s : args){
			list.add(s);
		}
		
		list.traverse();
		System.out.println("============Removing first index===================");
		list.remove();
		list.traverse();
		System.out.println("============Removing first index 3===================");
		list.remove(3);
		list.traverse();
		System.out.println("============Removing last index===================");
		//list.deleteNIndexFromEnd(4);
		list.deleteNthIndexFromEnd(1);
		list.traverse();
	}
}