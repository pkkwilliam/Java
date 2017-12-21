import java.util.LinkedList;
import java.util.Scanner;

public class GainEntropyCalculator{
	static int base = 2;
public static void main(String[]args){
	LinkedList<Double> list = new LinkedList<Double>();
	Scanner scan = new Scanner(System.in);
	// Top Entropy
	System.out.println("Top Positive"); 
	double topPositive = scan.nextInt();
	System.out.println("Top Negative"); 
	double topNegative = scan.nextInt();
	double topEntropy = entropy(topPositive,topNegative);
	System.out.println("Top Entropy = "+topEntropy);

	// Numbers of Sample
	double sample = topPositive + topNegative;

	// Parameter
	System.out.println("Number of Parameter");
    int parameter = scan.nextInt();
    for(int i = 0; i < parameter; i++){
    	System.out.println("Sample "+(i+1)+" Positive");
    	double positive = scan.nextInt();
    	System.out.println("Sample "+(i+1)+" Negative");
    	double negative = scan.nextInt();
    	double entropy = entropy(positive,negative);
    	System.out.println("Sample "+(i+1)+ " Entropy = "+entropy+"\n");
    	double localTotal = positive+negative;
    	double result = localTotal / sample * entropy;
    	list.add(result);
    }
    double result = topEntropy;
	while(!list.isEmpty()){
		result -= list.pollLast();
	}
	System.out.println("Final Gain = " + result);
}
private static double entropy(double positive, double negative){
	double localTotal = positive+negative;
	double positiveLogResult = 0;
	double negativeLogResult = 0;
    // do Calculation
	if(positive != 0){
		positiveLogResult = Math.log(positive/localTotal) / Math.log(base);
		positiveLogResult *= -(positive/localTotal);
	}	
	if(negative != 0){
		negativeLogResult = Math.log(negative/localTotal) / Math.log(base);
		negativeLogResult *= (negative/localTotal);
	}
    return positiveLogResult - negativeLogResult;
	}
}