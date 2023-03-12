package bai4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class CountManage extends UnicastRemoteObject implements Myinterface {

	protected CountManage() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String Count(String str) {
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
