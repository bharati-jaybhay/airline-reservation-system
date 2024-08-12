package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import model.Flight;


public class FlightDAO {

    private static DataSource dataSource;

    public FlightDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public FlightDAO() {
		// TODO Auto-generated constructor stub
	}

    public List<Flight> searchFlightsByOrigin(String origin) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flight WHERE origin = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, origin);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setF_id(rs.getInt("f_id"));
                    flight.setFlight_id(rs.getString("flight_id"));
                    flight.setOrigin(rs.getString("origin"));
                    flight.setDestination(rs.getString("destination"));
                    flight.setDeparture(rs.getTimestamp("departure"));
                    flight.setArrival(rs.getTimestamp("arrival"));
                    flights.add(flight);
                }
            }
        }
        return flights;
    }
    
    public boolean insertFlight(Flight flight) throws SQLException {
        String sql = "INSERT INTO flight (flight_id, origin, destination, departure, arrival) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, flight.getFlight_id());
            ps.setString(2, flight.getOrigin());
            ps.setString(3, flight.getDestination());
            ps.setTimestamp(4, new Timestamp(flight.getDeparture().getTime()));
            ps.setTimestamp(5, new Timestamp(flight.getArrival().getTime()));

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    public void deleteFlight(String flightId) throws SQLException {
        String sql = "DELETE FROM flight WHERE flight_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, flightId);
            ps.executeUpdate();
        }
    }


    public List<Flight> getAllFlights() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flight";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlight_id(rs.getString("flight_id"));
                flight.setOrigin(rs.getString("origin"));
                flight.setDestination(rs.getString("destination"));
                flight.setDeparture(rs.getTimestamp("departure"));
                flight.setArrival(rs.getTimestamp("arrival"));
                flights.add(flight);
            }
        }
        return flights;
    }

            
	private void closeAll(Connection conn, PreparedStatement ps, Object object) throws Exception {
		if (conn != null) {
			conn.close();
		}
		if (ps != null) {
			ps.close();
		}
		
	}
	
	
	public Flight searchFlightById(String flightId) throws SQLException {
	    Flight flight = null;
	    String sql = "SELECT * FROM flight WHERE flight_id = ?";

	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, flightId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                flight = new Flight();
	                flight.setF_id(rs.getInt("f_id"));
	                flight.setFlight_id(rs.getString("flight_id"));
	                flight.setOrigin(rs.getString("origin"));
	                flight.setDestination(rs.getString("destination"));
	                flight.setDeparture(rs.getTimestamp("departure"));
	                flight.setArrival(rs.getTimestamp("arrival"));
	            }
	        }
	    }
	    return flight;
	}
	
	 public boolean updateFlight(Flight flight) throws SQLException {
	        String sql = "UPDATE flight SET origin = ?, destination = ?, departure = ?, arrival = ? WHERE flight_id = ?";
	        try (Connection connection = dataSource.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, flight.getOrigin());
	            statement.setString(2, flight.getDestination());
	            statement.setTimestamp(3, flight.getDeparture());
	            statement.setTimestamp(4, flight.getArrival());
	            statement.setString(5, flight.getFlight_id());
	            int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        }
	    }
}