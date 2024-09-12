package Model;

public class TableDTO {
	private String tableName;
	private String columnName;
	private String datatypeString;
	private String lengthString;
	private String defaultString;
	private String notNull1;
	private String primaryKey;
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDatatypeString() {
		return datatypeString;
	}
	public void setDatatypeString(String datatypeString) {
		this.datatypeString = datatypeString;
	}
	public String getLengthString() {
		return lengthString;
	}
	public void setLengthString(String lengthString) {
		this.lengthString = lengthString;
	}
	public String getDefaultString() {
		return defaultString;
	}
	public void setDefaultString(String defaultString) {
		this.defaultString = defaultString;
	}
	public String getNotNull1() {
		return notNull1;
	}
	public void setNotNull1(String notNull1) {
		this.notNull1 = notNull1;
	}
	
	
	
	
	
	

}
