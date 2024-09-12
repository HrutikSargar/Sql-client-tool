package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;

public class DatabaseDAO {
	
	private static Connection connection=ConnectionHelper.helper();
	public int createDB(DatabaseDTO databaseDTO) {
		 String query="CREATE DATABASE ";
		 String dbName=databaseDTO.getDbName();
		query+=" "+dbName+";";
		System.out.println(query);
		 try {
			 PreparedStatement preparedStatement=connection.prepareStatement(query);
			int count=preparedStatement.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return -1;
		
	}
}
