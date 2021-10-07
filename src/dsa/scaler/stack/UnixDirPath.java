package dsa.scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class UnixDirPath {

    public static void main(String[] args) {
        String[] testSet = {
                "/home/",
                "/a/./b/../../c/",
                "../../../c",
                "/a/c/v/../../../../../",
                "/home//foo/"
        };
        for (String testData : testSet) {
            System.out.println(testData + " has path "+simplifyPath(testData));
        }
    }

    public static String simplifyPath(String A) {

        String[] pathArr = (String[]) Arrays.stream(A.split("/"))
                                .filter(path -> !path.equalsIgnoreCase("") && !path.equalsIgnoreCase("."))
                                .toArray(String[]::new);
        ArrayList<String> pathList = new ArrayList<>();

        for(String path : pathArr){

            if(!path.equalsIgnoreCase("..")){
                pathList.add(path);
                continue;
            }

            if(pathList.size() == 0){
                continue;
            }

            pathList.remove(pathList.size()-1);
        }
        StringBuffer result = new StringBuffer("/");
        for (int i=0;i<pathList.size();i++) {
            result.append(pathList.get(i));
            if(i != pathList.size()-1){
                result.append("/");
            }
        }
        return result.toString();
    }
}
