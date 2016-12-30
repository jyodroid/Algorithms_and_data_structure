package algoritms_data_structures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalanceBrackets {
//    public static boolean isBalanced(String expression) {
//    	
//    	
//        int expressionLength = expression.length();
//        
//    	if (expressionLength % 2 != 0 ){
//        	return false;
//        }
//        
//        StringBuilder firstBuilder = new StringBuilder(expression.substring(0, expressionLength/2));
//        StringBuilder seconBuilder = 
//        		new StringBuilder(expression.substring(expressionLength/2, expressionLength));
//        
//        while(firstBuilder.length() > 0){
//        	if(!closeChar(firstBuilder.charAt(0), seconBuilder.charAt(seconBuilder.length()-1))){
//        		return false;
//        	}
//    		System.out.println(firstBuilder.charAt(0));
//    		System.out.println(seconBuilder.charAt(seconBuilder.length()-1));
//        	firstBuilder.deleteCharAt(0);
//        	seconBuilder.deleteCharAt(seconBuilder.length()-1);
//        }
//        
//        return true;
//    }
	
  public static boolean isBalanced(String expression) {
	
	  java.util.Stack visited = new java.util.Stack();
	  ArrayDeque onExpression = new ArrayDeque();
	  
	  for (int i = 0; i < expression.length(); i++) {
		  onExpression.add(expression.charAt(i));
	  }
	  
	  while(!onExpression.isEmpty()){
		  
		  if(!visited.isEmpty() && closeChar((char)visited.peek(), (char)onExpression.peek())){
			  visited.pop();
			  onExpression.remove();
		  }else{
			  visited.push(onExpression.remove());
		  }
	  }
	  
	  return visited.isEmpty();
}
    
    public static boolean closeChar(char char1, char char2){
    	if(char1 == '{' && char2 == '}'){
    		return true;
    	}
    	if(char1 == '(' && char2 == ')'){
    		return true;
    	}
    	if(char1 == '[' && char2 == ']'){
    		return true;
    	}
    	return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
