package Test;

import java.io.File;
import java.io.IOException;

import xr.build.WriteTxt;

public class TestAppendJava {
	
	/**
	 * 失败告终
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		
		WriteTxt writeTxt=new WriteTxt();
		File file=new File("D:/myEclipse2017CIWork Space/teachcheckoutsys/src/com/aninstein/bean/AdmintablePO.java");
		writeTxt.writeAppend(file, "hahah");
		
	}
	
}
