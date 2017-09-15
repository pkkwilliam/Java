package Week3;

import java.util.LinkedList;
import java.util.Scanner;

// By Ka Kei Pun (William)
// I test this up to 10,000 factorial

public class GeneratingLargeFactorials {
public static void main(String[]args){
Scanner scan = new Scanner(System.in);
while(true){
	System.out.println("Please enter a postitive number to calculate factorial.");
	System.out.println("Or enter 0 to quit.");
	int factorial = scan.nextInt();
	if(factorial == 0)
		break;
	longFactorial(factorial);
}
}
static void longFactorial(int factorial){
LinkedList<String> resultLinkedList = new LinkedList<String>();
resultLinkedList.add("1");
	for(int i = 1; i <= factorial; i++){
		int addon = 0;
		for(int j = resultLinkedList.size() - 1; j >= 0; j--){
			int temp = Integer.valueOf(resultLinkedList.get(j).toString());
			resultLinkedList.remove(j);
			// Start Calculate
			temp = temp * i + addon;
			// Plug in numbers into linkedlist
			String plugin = checkString(temp % 1000);
			resultLinkedList.add(j, plugin);
			addon = temp / 1000;
			
		}
		// Add back all additional numbers to the front
		while (addon != 0){
			String plugin = checkString(addon % 1000);
			resultLinkedList.addFirst(plugin);
			addon /= 1000;
		}
	}
	System.out.println(resultLinkedList);
}
  
static String checkString(int i){
	String s = String.valueOf(i);
	while(s.length() < 3)
		s = "0" + s;
	return s;
}
}