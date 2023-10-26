package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddedPathway {
    int student_id;
    int pathway_id;

    public AddedPathway() {}

    public AddedPathway(int student_id, int pathway_id) {
        this.student_id = student_id;
        this.pathway_id = pathway_id;
    }

    public static ArrayList<AddedPathway> getList() {
        ArrayList<AddedPathway> addedPathwayList = new ArrayList<>();
        String query = "SELECT * FROM added_pathway";
        AddedPathway obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new AddedPathway();
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                addedPathwayList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return addedPathwayList;
    }

    public static boolean add(int student_id, int pathway_id) {
        String query = "INSERT INTO added_pathway (student_id, pathway_id) VALUES (?, ?)";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, student_id);
            ps.setInt(2, pathway_id);

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

    public static AddedPathway fetch(int student_id, int pathway_id) {
        AddedPathway obj = null;
        String query = "SELECT * FROM added_pathway WHERE student_id = ? AND pathway_id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, student_id);
            ps.setInt(2, pathway_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new AddedPathway();
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int student_id, int pathway_id) {
        String query = "DELETE FROM added_pathway WHERE student_id = ? AND pathway_id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, student_id);
            ps.setInt(2, pathway_id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<AddedPathway> searchAddedPathwayList(int student_id) {
        ArrayList<AddedPathway> addedPathwayList = new ArrayList<>();

        String query = "SELECT * FROM added_pathway WHERE student_id ='" + student_id + "'";

        AddedPathway obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new AddedPathway();
                obj.setStudent_id(rs.getInt("student_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                addedPathwayList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return addedPathwayList;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getPathway_id() {
        return pathway_id;
    }

    public void setPathway_id(int pathway_id) {
        this.pathway_id = pathway_id;
    }
}
