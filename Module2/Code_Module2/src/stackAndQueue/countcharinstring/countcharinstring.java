package stackAndQueue.countcharinstring;

import java.util.TreeMap;

public class countcharinstring {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String str = "hello welcome to da nang";
        str = str.toLowerCase();
        String[] s = str.split("");
        for (int i = 0; i < s.length; i++) {
            if (treeMap.containsKey(s[i])) {
                treeMap.put(s[i], treeMap.get(s[i]) + 1);
            } else {
                treeMap.put(s[i], 1);
            }
        }
        treeMap.remove(" ");
        System.out.println(treeMap.entrySet());
    }
}