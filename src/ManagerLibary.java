import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ManagerLibary extends UnicastRemoteObject implements MyInterface {
	Connection connection = ConnectionJDBC.getConnection();
	protected ManagerLibary() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(LibaryLan li) throws RemoteException {
		
	
	try {
		Statement statement = connection.createStatement();
		String SQL = "INSERT INTO language(vocabulary, category, vietnam, past) VALUES ('" + li.getVocabulary() + "','" + li.getCategory() + "','" + li.getVietnam() + "','" + li.getPast() + "');";
		//String SQL ="INSERT INTO nguyen(id) VALUES (1);";
		statement.executeUpdate(SQL);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("them tu that bai");
	}
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int update(LibaryLan vietnam) throws RemoteException {
		try {
			Statement statement = connection.createStatement();
			String SQL = "UPDATE language SET vocabulary='" + vietnam.getVocabulary() +
					"', Category='" + vietnam.getCategory() +
					"', past='" + vietnam.getPast() +
					"', vietnam='" + vietnam.getVietnam() +
					"' WHERE vietnam='" + vietnam
					.getVietnam() + "'";
			int n = statement.executeUpdate(SQL);
			if(n == 1) {
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(String location) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Statement statement = connection.createStatement();
			String SQL = "DELETE from language WHERE vietnam = '" + location + "'";
			int n = statement.executeUpdate(SQL);
			if(n == 1) {
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public LibaryLan select(String vocabulary) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * from language WHERE vocabulary = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, vocabulary);
			ResultSet srResultSet = statement.executeQuery();
			 while(srResultSet.next()){
	                //Retrieve by column name
	                String vocabulary1  = srResultSet.getString("vocabulary");
	                String Category = srResultSet.getString("Category");
	                String past = srResultSet.getString("past");
	                String vietnam = srResultSet.getString("vietnam");
	                LibaryLan li = new LibaryLan(vietnam, vocabulary1, Category, past);
	                return li;
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LibaryLan select2(String vietnam) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * from language WHERE vietnam = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, vietnam);
			ResultSet srResultSet = statement.executeQuery();
			 while(srResultSet.next()){
	                //Retrieve by column name
	                String vocabulary1  = srResultSet.getString("vocabulary");
	                String Category = srResultSet.getString("Category");
	                String past = srResultSet.getString("past");
	                String vietnam1 = srResultSet.getString("vietnam");
	                LibaryLan lan = new LibaryLan(vietnam1, vocabulary1, Category, past);
	                return lan;
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}




}
