package Week2;

public class EuclidsAlgorithm {
public static void main(String[]args){
	
	int firstNumber = 96;
	int secondNumber = 72;
	
	int test = euclidsAlgorithm(firstNumber,secondNumber);
	System.out.println(test);

}

// Euclid's ALgorithm
static int euclidsAlgorithm(int x, int y){
	int common = 0;
	while (y != 0){
		common = x % y;
		x = y;
		y = common;
	}
	return x;
}
}

