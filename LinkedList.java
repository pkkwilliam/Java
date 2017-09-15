package Week3;

public class LinkedList {
public static void main(String[]args){

	List list = new List();
	list.addOn(5);
	list.addOn(3);
	list.addOn(6);
	list.printAll();
}
}

class List{
	Number start;
	List(){
		start = null;
	}
	void addOn(int number){
		start = new Number(number, start);
	}
	void printAll(){
		Number current = start;
		while(current != null){
			System.out.print(current.number+" ");
			current = current.next;
		}
	}
}
class Number{
	int number;
	Number next;
	Number(int number, Number next){
		this.number = number;
		this.next = next;
	}
}