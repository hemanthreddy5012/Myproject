package webapptest.webapptest;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class OccurenceCount {

	public static TreeMap<String,Integer> sortByValue( TreeMap<String,Integer> map){
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
public static String getList(String s) {
	//String s="This is a test input for a program:22 $$ history&, one two#two or, three*three*three four!four!four!four story";
	
	StringBuffer buffer=new StringBuffer();
	TreeMap<String,Integer> map=new TreeMap<>();
	String[] arr=s.split("[\\W]");
	for(int i=0;i<arr.length;i++) {
		if(map.containsKey(arr[i])) {
			map.put(arr[i], map.get(arr[i])+1);
		}else {
			map.put(arr[i],1);
		}
		//System.out.println(arr[i]);
	}
	map.remove("");
	for(Map.Entry<String, Integer> entry:map.entrySet()) {
		buffer.append(entry.getKey()+"("+entry.getValue()+")<br/>");
		System.out.println(entry.getKey()+"("+entry.getValue()+")");
	}
	
	System.out.println("_____Frequency Order_______");
	
	buffer.append("_____Frequency Order_______<br/>");
	//This is to prnt frequency 
	for(Map.Entry<String, Integer> entry:sortByValue(map).entrySet()) {
		System.out.println(entry.getKey()+"("+entry.getValue()+")");
		buffer.append(entry.getKey()+"("+entry.getValue()+")<br/>");
		
	}
   
	return buffer.toString();
	//System.out.println(map);
}
}
