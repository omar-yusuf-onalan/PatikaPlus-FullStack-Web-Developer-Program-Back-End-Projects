package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int pathway_id;
    private String name;
    private String lang;

    private Pathway pathway;
    private User instructor;

    public Course(){}

    public Course(int id, int user_id, int pathway_id, String name, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.pathway_id = pathway_id;
        this.name = name;
        this.lang = lang;
        this.pathway = Pathway.fetch(pathway_id);
        this.instructor = User.fetch(pathway_id);
    }

    public static ArrayList<Course> getList() {
        ArrayList<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM course";
        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));
                courseList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return courseList;
    }

    public static boolean add(int userId, int pathwayId, String name, String lang) {
        String query = "INSERT INTO course (user_id, pathway_id, name, lang) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, pathwayId);
            ps.setString(3, name);
            ps.setString(4, lang);

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

    public static Course fetch(int id) {
        Course obj = null;
        String query = "SELECT * FROM course WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static Course fetch(String name) {
        Course obj = null;
        String query = "SELECT * FROM course WHERE name = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM course WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, int userId, int pathwayId, String name, String lang) {
        String query = "UPDATE course SET user_id = ?, pathway_id = ?, name = ?, lang = ? WHERE id = ?";

        if (fetch(name) != null && fetch(name).getId() != id) {
            Helper.showMessage("Course already exists\nEnter a different course name");
            return false;
        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, pathwayId);
            ps.setString(3, name);
            ps.setString(4, lang);
            ps.setInt(5, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Course> searchCourseList(int userId, int pathwayId, String name, String lang) {
        ArrayList<Course> courseList = new ArrayList<>();
        Object[] searchCriteria = {"user_id", userId, "pathway_id", pathwayId, "name", name, "lang", lang};

        String query = "SELECT * FROM course WHERE";
        boolean prefixAnd = false;

        for (int i = 0; i < searchCriteria.length; i += 2) {
            if (searchCriteria[i + 1] == null || searchCriteria[i + 1].toString().isEmpty()) {
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

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));
                courseList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return courseList;
    }

    public static ArrayList<Course> searchCourseListByUserId(int userId) {
        ArrayList<Course> courseList = new ArrayList<>();

        String query = "SELECT * FROM course WHERE user_id = '" + userId + "'";

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));
                courseList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return courseList;
    }

    public static ArrayList<Course> searchCourseListByPathwayId(int pathwayId) {
        ArrayList<Course> courseList = new ArrayList<>();

        String query = "SELECT * FROM course WHERE pathway_id = '" + pathwayId + "'";

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Course();
                obj.setId(rs.getInt("id"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setPathway_id(rs.getInt("pathway_id"));
                obj.setName(rs.getString("name"));
                obj.setLang(rs.getString("lang"));
                courseList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return courseList;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPathway_id() {
        return pathway_id;
    }

    public void setPathway_id(int pathway_id) {
        this.pathway_id = pathway_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Pathway getPathway() {
        return pathway;
    }

    public void setPathway(Pathway pathway) {
        this.pathway = pathway;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }
}
