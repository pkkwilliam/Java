package Week4;

import java.util.Stack;

public class InfixToPostfix {
public static void main(String[]args){
		
		String input = "c * b ^ a - (a + b)";
		infixToPostfix(input);	
		
	}
	static void infixToPostfix(String input){
		/* By Ka Kei Pun (William) 
		 * 
		 * Rule
		 * 
		 * 1. If the stack is empty, push current operator on the stack. Continue scanning.
		 * 2. If the current operator has higher precedence than the top operator of the
		 *    stack, push the current operator on the stack. Continue scanning.
		 * 3. If the current operator has lower than or equal to the precedence of the top 
		 *    operator of the stack, pop the stack and output the operator. Repeat this 
		 *    until either 1 | 2 become true. Push the current operator on the stack. 
		 *    Continue scanning.
		 */
		String result;
		char current;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < input.length(); i++){
			current = input.charAt(i);
			if((current >= 'A' && current <= 'Z') || (current >='a' && current <= 'z') || (current >= '0' && current <= '9'))
				System.out.print(input.charAt(i)+" ");
			
			else if(current == '+' || current == '-' || current == '*' || current == '/' 
					|| current == '(' || current == ')' || current == '^'){
				if(stack.isEmpty())                                   // Rule # 1
					stack.push(current);
				else if(current == '(')
					stack.push(current);
				else if(current == ')'){
					 while(stack.peek() != '(')
						 System.out.print(stack.pop()+" "); 
					 stack.pop();
				 }
				else{
					 int currentOperand = getPrecedence(current);
					 int stackTop = getPrecedence(stack.peek());
					 if(currentOperand > stackTop)                    // Rule # 2
						stack.push(current);
					 else if(currentOperand <= stackTop){             // Rule # 3
						 while(currentOperand <= stackTop && !stack.isEmpty())
							 System.out.print(stack.pop()+" ");
						 stack.push(current);
					 }
				}
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	static int getPrecedence(char operator){
		char operands [] = {'+','-','*','/','(','^'};              
		int precendence [] = {1,1,2,2,0,3};                               
		int returnPrecedence = 0;
		for(int i = 0; i < operands.length; i++)
			if(operator == operands[i]){
				returnPrecedence = i;
				break;
			}
		return precendence[returnPrecedence];			
	}
}
