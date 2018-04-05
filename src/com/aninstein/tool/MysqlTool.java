package com.aninstein.tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MysqlTool {

	public static  final String DATABASENAME="teachcheckoutsys";

	DBTool dbTool=new DBTool();
	Connection connection=dbTool.getConnection();
	
	//获取数据库所有表格名
	public List<String> getTableNameByDatabaseName(String databaseName) throws Exception {
		//查询所有表名的sql
		String selectNameSql="SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '"+databaseName+"'";
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(selectNameSql);
		
		//遍历表名、视图名存入List
		List<String> tableList=new ArrayList<String>();
		
		//正则表达式用于去除视图名
		Pattern pattern = Pattern.compile(".*view.*");
		
		while(resultSet.next()){
			//先判断是不是视图
			Matcher matcher = pattern.matcher(resultSet.getString("TABLE_NAME"));
			
			//如果不是视图
			if(!matcher.matches()){
				tableList.add(resultSet.getString("TABLE_NAME"));
			}
		}
		return tableList;
	}
	
	//获取数据库各个表的所有列名
	public List<String> getTableColumnsByTableName(String databaseName,String tableName) throws Exception {
		
		//查询字段名的sql
		String selectColumnSql="select COLUMN_NAME "
				+ "from information_schema.COLUMNS "
				+ "where table_name = '"+tableName+"' and table_schema = '"+databaseName+"'";
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(selectColumnSql);
		
		List<String> columnsList=new ArrayList<String>();
		
		while(resultSet.next()){
			columnsList.add(resultSet.getString("COLUMN_NAME"));
		}
		
		return columnsList;
	}
	
	//更改数据库字符集
	public int changeDatabaseCharset(String databaseName,String Charset,String CharsetCollate) {
		String setSql="ALTER DATABASE "+databaseName+" DEFAULT CHARACTER SET "+Charset+" COLLATE "+CharsetCollate+"";
		int count=0;
		try {
			Statement stm=connection.createStatement();
			count=stm.executeUpdate(setSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//更改数据库所有字段的字符集
	public void changeDatabaseTableCharset(String databaseName,String Charset,String CharsetCollate) {

		//查询所有表名
		String selectNmae="SELECT TABLE_NAME "
				+ "FROM INFORMATION_SCHEMA.TABLES "
				+ "WHERE TABLE_SCHEMA = '"+databaseName+"'";
		
		//执行sql语句
		PreparedStatement pstm;
		try {
			pstm = connection.prepareStatement(selectNmae);
			ResultSet rs_tableName;
			rs_tableName = pstm.executeQuery();
		
		//批量生成sql语句并且批量执行
		Statement stm =connection.createStatement(); 
		
		//遍历表名、视图名存入List
		List<String> list=new ArrayList<String>();
		
		//正则表达式用于去除视图名
		Pattern pattern = Pattern.compile(".*view.*");
		System.out.println("显示表格名：");
		while(rs_tableName.next()){
			//先判断是不是视图
			Matcher matcher = pattern.matcher(rs_tableName.getString("TABLE_NAME"));
			
			//批量生成sql语句并且执行
			if(!matcher.matches()){
			list.add(rs_tableName.getString("TABLE_NAME"));
			System.out.println(rs_tableName.getString("TABLE_NAME"));
			
			//这段sql语句可以改变表格、表格字段（char，varchar，text）类型的字符集
			stm.addBatch("ALTER TABLE "+rs_tableName.getString("TABLE_NAME")
			+" CONVERT TO CHARACTER SET "+Charset+" COLLATE "+CharsetCollate+"");
			
			}
		}
		
		
		
		int[] count = stm.executeBatch();
		
		
		System.out.println();
		System.out.println("数组长度为："+count.length);
		for(int i=0;i<count.length;i++){
			System.out.println(list.get(i)+"，改变了"+count[i]+"字段");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//清空数据库
	public void DeleteAllData(String databaseName) {//清空所有数据库条目

		//查询所有表名
		String selectNmae="SELECT TABLE_NAME "
				+ "FROM INFORMATION_SCHEMA.TABLES "
				+ "WHERE TABLE_SCHEMA = '"+databaseName+"'";
		//执行sql语句
		PreparedStatement pstm;
		try {
			pstm = connection.prepareStatement(selectNmae);
			ResultSet rs_tableName;
			rs_tableName = pstm.executeQuery();
		
		//批量生成sql语句并且批量执行
		Statement stm =connection.createStatement(); 
		
		//遍历表名、视图名存入List
		List<String> list=new ArrayList<String>();
		
		//正则表达式用于去除视图名
		Pattern pattern = Pattern.compile(".*view.*");
		System.out.println("显示表格名：");
		while(rs_tableName.next()){
			//先判断是不是视图
			Matcher matcher = pattern.matcher(rs_tableName.getString("TABLE_NAME"));
			
			//批量生成sql语句并且执行
			if(!matcher.matches()){
			list.add(rs_tableName.getString("TABLE_NAME"));
			System.out.println(rs_tableName.getString("TABLE_NAME"));
			
			//这段sql语句可以清空表格
			stm.addBatch("TRUNCATE TABLE "+rs_tableName.getString("TABLE_NAME"));
			}
		}
		
		
		
		int[] count = stm.executeBatch();
		
		
		System.out.println();
		System.out.println("一共有表格："+count.length+"个");
		for(int i=0;i<count.length;i++){
			System.out.println("表格"+list.get(i)+"，删除了"+count[i]+"条记录！");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
