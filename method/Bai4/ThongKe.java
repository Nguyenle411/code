package Bai4;

import java.util.HashMap;

public class ThongKe implements Myinterface {
	String string;
    public ThongKe() {
		super();
	}
	@Override
	public String thongke(String str) {
		String[] words = str.split(" ");
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        StringBuilder output = new StringBuilder();
        output.append("Word count: \n");
        for (String word : wordCount.keySet()) {
            output.append(word + " : " + wordCount.get(word) + "\n");
        }
        return output.toString();
	}
}