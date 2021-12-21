package dsa.scaler.stack;

import java.awt.desktop.SystemSleepEvent;
import java.util.HashSet;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        System.out.println(evaluateExpression.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evaluateExpression.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
    public int evalRPN(String[] A) {
        HashSet<String> signs = new HashSet<>();
        signs.add("+");
        signs.add("-");
        signs.add("*");
        signs.add("/");
        Stack<String> expStack = new Stack<>();
        for(String data : A){
            if(!signs.contains(data)){
                expStack.push(data);
                continue;
            }
            int rightOp = Integer.parseInt(expStack.pop());
            int leftOp = Integer.parseInt(expStack.pop());
            expStack.push(String.valueOf(performOperation(leftOp,rightOp,data)));
        }
        return Integer.parseInt(expStack.pop());
    }

    int performOperation(int leftOp,int rightOp,String operator){
        if(operator.equals("+")){
            return leftOp+rightOp;
        }

        if(operator.equals("-")){
            return leftOp-rightOp;
        }

        if(operator.equals("*")){
            return leftOp*rightOp;
        }

        return leftOp/rightOp;
    }

}
