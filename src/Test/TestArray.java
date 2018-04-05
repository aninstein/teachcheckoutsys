package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestArray {

	public static void main(String[] args) throws Exception {
		ObjectMapper objectMapper=new ObjectMapper();
		List<String> list=new ArrayList<String>();
		list.add("C++程序设计");
		list.add("数据结构");
		list.add("javaweb");
		String str=objectMapper.writeValueAsString(list);
		List<String> list2=objectMapper.readValue(str, new TypeReference<List<String>>() {
		});
		System.out.println(str);
	}
	
}
