package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pathway {
    private int id;

    private String name;

    public Pathway(){}

    public Pathway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ArrayList<Pathway> getList() {
        ArrayList<Pathway> pathwayList = new ArrayList<>();
        String query = "SELECT * FROM pathway";
        Pathway obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Pathway(rs.getInt("id"), rs.getString("name"));
                pathwayList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pathwayList;
    }

    public static boolean add(String name) {
        String query = "INSERT INTO pathway (name) VALUES (?)";

        if (fetch(name) != null) {
            Helper.showMessage("Pathway already exists\nEnter a different Pathway name");
            return false;
        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);

            int response = ps.executeUpdate();

            if (response == -1) {
                Helper.showMessage("error");
            }
            ps.close();
            return response != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static Pathway fetch(String name) {
        Pathway obj = null;
        String query = "SELECT * FROM pathway WHERE name = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Pathway();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static Pathway fetch(int id) {
        Pathway obj = null;
        String query = "SELECT * FROM pathway WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Pathway();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM pathway WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, String name) {
        String query = "UPDATE pathway SET name = ? WHERE id = ?";

        if (fetch(name) != null && fetch(name).getId() != id) {
            Helper.showMessage("Pathway already exists\nEnter a different pathway name");
            return false;
        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Pathway> searchPathwayList(String name) {
        ArrayList<Pathway> pathwayList = new ArrayList<>();
        String[] searchCriteria = {"name", name};

        String query = "SELECT * FROM pathway WHERE";
        boolean prefixAnd = false;

        for (int i = 0; i < searchCriteria.length; i += 2) {
            if (searchCriteria[i + 1].isEmpty()) {
                continue;
            }

            if (prefixAnd) {
                query += " AND";
            }

            query += " " + searchCriteria[i] + " LIKE " + "'%" + searchCriteria[i + 1] + "%'";

            if (!prefixAnd) {
                prefixAnd = true;
            }
        }

        Pathway obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Pathway();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                pathwayList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pathwayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
