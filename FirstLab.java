
//Variant 4 ---- Знайти лише ті слова, кожне з яких складається з літер що не повторюються.
import java.io.*;
import java.util.*;

public class FirstLab {
    public static char[] subStr(String str, char [] array){
        str = str.replaceAll("(?U)[^\\p{L}\\s]+","");
        if (str.length() > 28){
            str = str.substring(0,29);
        }
        str = str.toLowerCase();
        array = str.toCharArray();
        return array;
    }
    public static void main(String[] args) {
            try {
                String dir = "test2.txt";
                File file = new File(dir);
                Scanner scanner = new Scanner(file);
                HashSet<String> mSet = new HashSet<String>();
                String myStr;
                char[] arr = new char[28];
                boolean flag = false;
                while (scanner.hasNextLine()) {
                    arr = subStr(scanner.next(), arr);
                    flag = false;
                    loop:
                    {
                        for (int i = 0; i < arr.length; i++) {
                            for (int j = i; j < arr.length; j++) {
                                if (i != j && arr[i] == arr[j]) {
                                    flag = true;
                                    break loop;
                                }
                            }
                        }
                    }
                    if (!flag) {
                        myStr = new String(arr);
                        mSet.add(myStr);
                    }
                }
                for (String s : mSet)
                    System.out.println(s);
            }
            catch (Exception e) {
                    System.out.println("File not found!");
            }

    }
}
