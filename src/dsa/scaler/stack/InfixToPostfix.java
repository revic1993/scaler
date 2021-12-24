package dsa.scaler.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class InfixToPostfix {
    ArrayList<HashSet<String>> opPrecedence;

    InfixToPostfix(){
        opPrecedence = new ArrayList<>();
        HashSet<String> currentPrecedence = new HashSet<>();
        currentPrecedence.add("^");
        opPrecedence.add(currentPrecedence);

        currentPrecedence = new HashSet<>();
        currentPrecedence.add("*");
        currentPrecedence.add("/");
        opPrecedence.add(currentPrecedence);

        currentPrecedence = new HashSet<>();
        currentPrecedence.add("+");
        currentPrecedence.add("-");
        opPrecedence.add(currentPrecedence);
    }

    public String solve(String A){
        Stack<String> expStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(char a : A.toCharArray()){
            if(a == ')'){
                while(!expStack.empty() && !expStack.peek().equals("(")){
                    sb.append(expStack.pop());
                }
                expStack.pop();
                if(sb.length() == 0){
                    continue;
                }
                expStack.push(solveForOp(toStringArr(sb.reverse().toString())));
                sb = new StringBuilder();
            }else{
                expStack.push(String.valueOf(a));
            }
        }
        String[] data = new String[expStack.size()];
        int i=expStack.size()-1;
        while(!expStack.isEmpty()){
            data[i--] = expStack.pop();
        }
        return solveForOp(data);
    }

    public String solveForOp(String[] data){
        Stack<String> expStack = new Stack<>();
        for(HashSet<String> currentOp :  opPrecedence){
            for(String c: data){
                if(expStack.isEmpty()){
                    expStack.push(c);
                    continue;
                }

                if(currentOp.contains(expStack.peek())){
                    StringBuilder sb = new StringBuilder();
                    String operator = expStack.pop();
                    String leftOperand = expStack.pop();
                    sb.append(leftOperand);
                    sb.append(c);
                    sb.append(operator);
                    expStack.push(sb.toString());
                }else{
                    expStack.push(c);
                }
            }

            if(expStack.size() == data.length){
                expStack = new Stack<>();
                continue;
            }
            data = new String[expStack.size()];
            for(int i=expStack.size()-1;i>=0;i--){
                data[i] = expStack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String datum : data){
            sb.append(datum);
        }
        return sb.toString();
    }

    public String[] toStringArr(String value){
        String[] data = new String[value.length()];
        for(int i=0;i<value.length();i++){
            data[i] = String.valueOf(value.charAt(i));
        }
        return data;
    }
}
