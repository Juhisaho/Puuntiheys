package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Puuntiheys;


public class JDBCPuuntiheysDAO implements PuuntiheysDAO {

	@Override
	public List<Puuntiheys> getAll() {
		// TODO Auto-generated method stub
		List<Puuntiheys> items = new ArrayList<>();
		Database database = new Database();
		Connection connection = database.connect();
		
		String sql = "SELECT * FROM Balsalevy";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					Puuntiheys levy = new Puuntiheys(result.getInt("id"), result.getDouble("tiheys"), result.getDouble("korkeus"), result.getDouble("leveys"), result.getDouble("paino"), result.getDouble("pituus"), result.getString("grain"));
					items.add(levy);
				}
			}
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Puuntiheys getItem(int id) {
		// TODO Auto-generated method stub
		for (Puuntiheys levy : this.getAll()) {
			if (levy.getId() == id) {
				return levy;
			}
		}
		
		return null;
	}
	
	@Override
	public boolean addItem(Puuntiheys levy) {
		// TODO Auto-generated method stub
		int id = 0;
		for (Puuntiheys b : this.getAll()) {
			if (b.getId() > id) {
				id = b.getId();
			}
		}
		
		id++;

		Database database = new Database();
		Connection connection = database.connect();
		String sql = "INSERT INTO Balsalevy VALUES(?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setLong(1, id);
			statement.setDouble(2, levy.getTiheys());
			statement.setDouble(3, levy.getPaksuus());
			statement.setDouble(4, levy.getLeveys());
			statement.setDouble(5, levy.getPaino());
			statement.setDouble(6, levy.getPituus());
			statement.setString(7, levy.getGrain());
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			}
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeItem(Puuntiheys levy) {
		Database database = new Database();
		Connection connection = database.connect();
		String sql = "DELETE FROM Balsalevy WHERE id = ?";		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setLong(1, levy.getId());
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			}
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	
			
		
}