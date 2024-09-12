package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;

import com.mysql.cj.protocol.a.BinaryResultsetReader;

import Model.DatabaseDAO;
import Model.DatabaseDTO;
import Model.DescribeDTO;
import Model.TableDAO;
import Model.TableDTO;
@WebServlet( urlPatterns = {"/createTable","/DescTable" ,"/WelcomePage","/pushData" ,"/ConfirmDeleteTable" ,"/createDB" , "/SeeAvailableDB"} )
//@WebServlet("/createTable " )
public class CreateTable extends HttpServlet{
	TableDAO dao=new TableDAO();
	 String  PublictableName="";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pathString=req.getServletPath();
		String secondFormValue=req.getParameter("btnOne");
		String insertDataPage=req.getParameter("insert");
		
		switch (pathString){
		case "/createTable":
			creteTable(req,resp);
//			showDatabase(req,resp);
			break;
		case "/DescTable":
			if (secondFormValue.equals("DescTable")) {
				descTable(req,resp);
			}else if (secondFormValue.equals("showDatabases")) {
				showDatabase(req,resp);
			} else if(secondFormValue.equals("InsertData")) {
				InsertData(req,resp);
			}else if(secondFormValue.equals("DeleteTable")) {
//				deleteTable(req,resp);
				RequestDispatcher dispatcher=req.getRequestDispatcher("DeleteWarning.html");
				dispatcher.forward(req, resp);
				break;
			}
			break;
		case "/pushData":
			if (insertDataPage.equals("InsertDataToList")) {
				insertDataToList(req,resp);
			}else if (insertDataPage.equals("InsertDataTODb")) {
				pushData(req,resp);
			}
			
			break;
		case "/ConfirmDeleteTable":
			deleteTable(req,resp);
			break;
		case "/createDB":
			createDB(req,resp);
			break;
		case "/SeeAvailableDB":
			showDatabase(req,resp);
			break;
		}

		
	}
	//METHOD CREATED TO INSERT DATA INTO ARRAYLIST , 
	//THEN INSERT DATA OF ARRAYLIST INTO DB 
	private void insertDataToList(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	//METHOD CREATED TO CREATE NEW TABLE 
	private void createDB(HttpServletRequest req, HttpServletResponse resp) {
		
		String dBName=req.getParameter("DbName");
		DatabaseDTO databaseDTO=new DatabaseDTO();
		databaseDTO.setDbName(dBName);
		
		
		DatabaseDAO dao=new DatabaseDAO();
		int  count=dao.createDB(databaseDTO);
		
		if (count>=0) {
			System.out.println("Table Created Successfully");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("DBCreationNotify.jsp");
			PrintWriter printWriter;
			
			try {
////				printWriter = resp.getWriter();
////				resp.setContentType("text/html");
////				printWriter.print("<html><body>");
////				printWriter.print("<div>");
////				printWriter.print("<h1>database created successfully</h1>");
////				printWriter.print("</div>");
////				printWriter.print("</body></html>");
				dispatcher.forward(req, resp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Something Went wrong");
		}
		
		
	}


	private void deleteTable(HttpServletRequest req, HttpServletResponse resp) {
		TableDAO dao=new TableDAO();
		int count=dao.deleteTable();
		if(count>=0) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("DeleteTableInfo.html");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private void pushData(HttpServletRequest req, HttpServletResponse resp) {	
		//get data from insertData .java server pages file to insert it into database.
		String [] value1=req.getParameterValues("value1");
	
		TableDAO dao=new TableDAO();
		int count=dao.pushData(value1);
	
			try {
				RequestDispatcher dispatcher=req.getRequestDispatcher("InsertData.jsp");
				PrintWriter printWriter=resp.getWriter();
				
				 resp.setContentType("text/html");
				 printWriter.print("<html><body>");
				 printWriter.print("<div>"); 
				 printWriter.print("<h1>1 record inserted</h1>");
				 printWriter.print("</div>");
				 printWriter.print("</body></html>");
		
				dispatcher.include(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

		System.out.println(count+" count value");
//		for(int a=0;a<value1.length;a++) {
//			System.out.println(value1[a]);
//		}
		
		
	}
	private void InsertData(HttpServletRequest req, HttpServletResponse resp) {
		TableDAO t1=new TableDAO();
		TableDTO dto=new TableDTO();
		dto.setTableName(PublictableName);
		ArrayList<DescribeDTO>dbArrayList1=  t1.InsertData(dto);
		
		try {
			req.setAttribute("data", dbArrayList1);
			RequestDispatcher dispatcher=req.getRequestDispatcher("InsertData.jsp");
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void showDatabase(HttpServletRequest req, HttpServletResponse resp) {
		TableDAO t1=new TableDAO();
		ArrayList<DatabaseDTO> dBArrayList = t1.showDatabases();
		
//		for(DatabaseDTO d:dBArrayList) {
//			System.out.println(d.getDbName());
//		}
		try {
			req.setAttribute("DBdata", dBArrayList);
			RequestDispatcher dispatcher=req.getRequestDispatcher("SeeavailableDatabbases.jsp");
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void descTable(HttpServletRequest req, HttpServletResponse resp) {
		TableDTO dto =new TableDTO();
		dto.setTableName(PublictableName);
		System.out.println("Table name "+PublictableName);
		 ArrayList<DescribeDTO> dataArrayList = dao.descTable(dto);
		 for(DescribeDTO a: dataArrayList) {
			 System.out.println(a.getFeild());
		 }
		 try {
			    req.setAttribute("data", dataArrayList);
			 	RequestDispatcher dispatcher=req.getRequestDispatcher("Desc.jsp");
			    dispatcher.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void creteTable(HttpServletRequest req, HttpServletResponse resp) {
	
		String tableName=req.getParameter("tableName");
		
		//Setting global variable value of table name.
		PublictableName=tableName;
		
		String [] coloumName=req.getParameterValues("columnName");
		String [] datatypeName=req.getParameterValues("select");
		String [] length=req.getParameterValues("length");
		String [] defaultv=req.getParameterValues("default");	
		String  primaryKey=req.getParameter("primaryKey");
		String [] notnull=req.getParameterValues("notNull");
//		String  primaryKey=req.getParameter("primaryKey");
		System.out.println(Arrays.toString(notnull));
		System.out.println(tableName);
		
		ArrayList<TableDTO> data=new ArrayList<>();
		TableDTO  t1=null;
		
		for (int i = 0; i < coloumName.length; i++) {
			if (!coloumName[i].isEmpty()) {
				t1=new TableDTO();
				
				String column=coloumName[i];
				String datatype=datatypeName[i];
				String lengthValue=length[i];
				String defaultValue=defaultv[i];
				
				
				if(notnull != null) {
					if(notnull.length > 0) {
						for(int j = 0; j < notnull.length; j++) {
							if (Integer.parseInt(notnull[j]) == i) {
								t1.setNotNull1(notnull[j]);
								System.out.println("value setted");
							}
						}
					}
				}
				t1.setPrimaryKey(primaryKey);
				t1.setTableName(tableName);
				t1.setColumnName(column);
				t1.setDatatypeString(datatype);
				t1.setLengthString(lengthValue);
				t1.setDefaultString(defaultValue);
			
				//add object to ArrayList
				data.add(t1);
				//System.out.println(column +" "+ datatype+" "+lengthValue+" "+defaultValue);
			}
		}
		int count= dao.createTable(data);
		if (count>=0) {
			try {
				req.setAttribute("data",data);
				RequestDispatcher rdDispatcher=req.getRequestDispatcher("second.jsp");
				rdDispatcher.forward(req, resp);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			RequestDispatcher  rdDispatcher=req.getRequestDispatcher("created2.jsp");
//			try {
//				rdDispatcher.forward(req, resp);
//			} catch (ServletException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}
}
