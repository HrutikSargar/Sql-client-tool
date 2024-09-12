package Model;

import java.beans.beancontext.BeanContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.mysql.cj.xdevapi.PreparableStatement;

public class TableDAO {
	
   private static Connection connection=ConnectionHelper.helper();
//   private final static String descTableString="Desc ?";
   
   private final static String showDB="show Databases";
   private final static String showTables="show tables";
   private  static String deleteTable="";
   private final static String showInsertData="select ";
   private static String tableNameString="";
   static String tableName;
   
   
   private  static List<TableDTO> tableDataStructure;
   public int createTable(List<TableDTO> data) {
	  
	   String primaryKeyNameString="";
	   
	   
	   for(TableDTO d: data) {
		   tableNameString=d.getTableName();
		   primaryKeyNameString=d.getPrimaryKey();
	}
	   System.out.println("table name is =>"+tableNameString);
	 
	   System.out.println("primary key Name is =>"+primaryKeyNameString);
	   String create = "create table "+tableNameString+"(";
	   
	   //Setting table data Structure value to global Arraylist to use it into another methods
	   tableDataStructure=data;
	   
	   //iterating through 
	   for(int a=0;a<data.size();a++) {
		   
		   if (data.get(a).getDatatypeString().equals("int") || data.get(a).getDatatypeString().equals("double")) {
			   
			  create=create+" "+ data.get(a).getColumnName() +" "+data.get(a).getDatatypeString();
			  if(!data.get(a).getDefaultString().isEmpty()) {
					create+=" default '"+data.get(a).getDefaultString()+"'";
				}
			  //if column has not null constraint then add that constraint to concatination
			  
			  if (data.get(a).getNotNull1()!=null) {
				  create+=" not null ";	
			}
		   }
//		   if (data.get(a).getDatatypeString().equals("double")) {
//				  create=create+" "+ data.get(a).getColumnName() +" "+data.get(a).getDatatypeString();
//				  
//				  if(!data.get(a).getDefaultString().isEmpty()) {
//						create+=" default '"+data.get(a).getDefaultString()+"'";
//					}
//				  if (!data.get(a).getNotNull1().isEmpty()) {
//					  create+="not null ";	
//				}
//			}
		   if (data.get(a).getDatatypeString().equals("varchar") || data.get(a).getDatatypeString().equals("char")) {
			   	create=create+ " "+ data.get(a).getColumnName()+" "+ data.get(a).getDatatypeString()+"("+data.get(a).getLengthString()+")";
			if (!(data.get(a).getDefaultString().isEmpty())) {
				create=create + " default '"+ data.get(a).getDefaultString()+"'";
				}
			if (data.get(a).getNotNull1() != null) {
				  create+="not null ";	
			}
		}
		   
//		   if (data.get(a).getDatatypeString().equals("char")) {
//				create=create+ " "+ data.get(a).getColumnName()+" "+ data.get(a).getDatatypeString()+"("+data.get(a).getLengthString()+")";
//				if (!(data.get(a).getDefaultString().isEmpty())) {
//					create=create + " default "+ data.get(a).getDefaultString()+"'";
//					}
//				if (!data.get(a).getNotNull1().isEmpty()) {
//					  create+="not null ";	
//				}
//			}
		  
		   if(a < data.size()-1) {
				create+=",";
			}
		  // System.out.println(create)
	}
	   for(int a=0;a<data.size();a++) {
		   if (a==Integer.parseInt(primaryKeyNameString)) {
			   create +=", primary key ("+data.get(Integer.parseInt(primaryKeyNameString)).getColumnName() +")";
			   break;
		}
	   }
	   create=create+");";
	   	
	   System.out.println(create);
	   Statement statement;
	   int count=-1;
	try {
		statement = connection.createStatement();
		  count=  statement.executeUpdate(create);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
}

public static ArrayList<DescribeDTO> descTable(TableDTO dto) {
	ArrayList<DescribeDTO> data=new ArrayList<DescribeDTO>();
	try {
		PreparedStatement preparableStatement=connection.prepareStatement("desc "+dto.getTableName()+"");
		 tableName=dto.getTableName();
		System.out.println("desc table name is"+dto.getTableName());
//		preparableStatement.setString(1, dto.getTableName());
		ResultSet rs=preparableStatement.executeQuery();
		DescribeDTO describeDTO=null;
	
		while(rs.next()) {
			describeDTO=new DescribeDTO();
			
			describeDTO.setFeild(rs.getString(1));
			describeDTO.setType(rs.getString(2));
			describeDTO.setNull(rs.getString(3));
			describeDTO.setKey(rs.getString(4));
			describeDTO.setDefauString(rs.getString(5));
			describeDTO.setExtraString(rs.getString(6));
			
			System.out.println(rs.getString(1));
			//adding data to arraylist
			data.add(describeDTO);
			
		}
		//returning arraylist
		return data;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//return null;
	return data;	
}

public ArrayList<DatabaseDTO> showDatabases() {
	// show databases functionality dya.
	
	ArrayList<DatabaseDTO>dbList=new ArrayList<DatabaseDTO>();
	try {
		PreparedStatement preparedStatement=connection.prepareCall(showDB);
		ResultSet resultSet= preparedStatement.executeQuery();
		DatabaseDTO databaseDTO=null;
		while(resultSet.next()) {
			databaseDTO=new DatabaseDTO();
			
			databaseDTO.setDbName(resultSet.getString(1));
			dbList.add(databaseDTO);
		}
		return dbList;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dbList;	
}

public ArrayList<DescribeDTO> InsertData(TableDTO dto) {
	// TODO Auto-generated method stub
	ArrayList<DescribeDTO> data=new ArrayList<DescribeDTO>();
	try {
		PreparedStatement preparableStatement=connection.prepareStatement("desc "+dto.getTableName()+"");
		System.out.println("desc table name is"+dto.getTableName());
//		preparableStatement.setString(1, dto.getTableName());
		ResultSet rs=preparableStatement.executeQuery();
		DescribeDTO describeDTO=null;
	
		while(rs.next()) {
			describeDTO=new DescribeDTO();
			
			describeDTO.setFeild(rs.getString(1));
			describeDTO.setType(rs.getString(2));
			describeDTO.setNull(rs.getString(3));
			describeDTO.setKey(rs.getString(4));
			describeDTO.setDefauString(rs.getString(5));
			describeDTO.setExtraString(rs.getString(6));
			
			System.out.println(rs.getString(1));
			//adding data to arraylist
			data.add(describeDTO);
			
		}
		//returning arraylist
		return data;
		
	}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	return data;
	}

public int pushData(String[] value1) {
	
	//String generation starts here 
	String insertQuery="insert into "+tableNameString+" values( ";
	
	//System.out.println(tableNameString+"name");
	
			for(int a=0;a<value1.length;a++) {	
			if (tableDataStructure.get(a).getDatatypeString().equals("int")) {
				insertQuery+=value1[a];
			}else {
				insertQuery+="'"+value1[a]+"'";
			}
			if (a<value1.length-1) {
				insertQuery+=",";
			}
		}
			insertQuery+=");";
	try {
		Statement statement=connection.createStatement();
		int count=statement.executeUpdate(insertQuery);
		System.out.println(insertQuery);
		return count;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return -1;	
}

public int deleteTable() {
	deleteTable="drop table "+tableNameString;
	Statement statement;
	try {
		statement = connection.createStatement();
		int count=statement.executeUpdate(deleteTable);
		return count;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;	
	
	}
	
}

