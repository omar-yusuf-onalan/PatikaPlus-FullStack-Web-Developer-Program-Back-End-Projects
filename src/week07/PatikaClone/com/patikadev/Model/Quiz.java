package week07.PatikaClone.com.patikadev.Model;

import week07.PatikaClone.com.patikadev.Helper.DBConnector;
import week07.PatikaClone.com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    int id;
    int content_id;
    String question;
    String a, b, c, d;
    String answer;

    Content content;

    public Quiz() {}

    public Quiz(int id, int content_id, String question, String a, String b, String c, String d, String answer) {
        this.id = id;
        this.content_id = content_id;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
        this.content = Content.fetch(content_id);
    }

    public static ArrayList<Quiz> getList() {
        ArrayList<Quiz> quizList = new ArrayList<>();
        String query = "SELECT * FROM quiz";
        Quiz obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setA(rs.getString("a"));
                obj.setB(rs.getString("b"));
                obj.setC(rs.getString("c"));
                obj.setD(rs.getString("d"));
                obj.setAnswer(rs.getString("answer"));
                quizList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return quizList;
    }

    public static boolean add(int content_id, String question, String a, String b, String c, String d, String answer) {
        String query = "INSERT INTO quiz (content_id, question, a, b, c, d, answer) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);
            ps.setString(2, question);
            ps.setString(3, a);
            ps.setString(4, b);
            ps.setString(5, c);
            ps.setString(6, d);
            ps.setString(7, answer);

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

    public static Quiz fetch(int id) {
        Quiz obj = null;
        String query = "SELECT * FROM quiz WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setA(rs.getString("a"));
                obj.setB(rs.getString("b"));
                obj.setC(rs.getString("c"));
                obj.setD(rs.getString("d"));
                obj.setAnswer(rs.getString("answer"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM quiz WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, int content_id, String question, String a, String b, String c, String d, String answer) {
        String query = "UPDATE quiz SET content_id = ?, question = ?, a = ?, b = ?, c = ?, d = ?, answer = ? WHERE id = ?";

        if (!answer.equals("A") && !answer.equals("B") && !answer.equals("C") && !answer.equals("D")) {
            Helper.showMessage("Answer must be set to A, B, C, or D");
            return false;
        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);
            ps.setString(2, question);
            ps.setString(3, a);
            ps.setString(4, b);
            ps.setString(5, c);
            ps.setString(6, d);
            ps.setString(7, answer);
            ps.setInt(8, id);

            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Quiz> searchQuizList(int content_id, String question, String a, String b, String c, String d, String answer) {
        ArrayList<Quiz> quizList = new ArrayList<>();
        Object[] searchCriteria = {"content_id", content_id, "question", question, "a", a, "b", b, "c", c, "d", d, "answer", answer};

        String query = "SELECT * FROM quiz WHERE";
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

        Quiz obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setA(rs.getString("a"));
                obj.setB(rs.getString("b"));
                obj.setC(rs.getString("c"));
                obj.setD(rs.getString("d"));
                obj.setAnswer(rs.getString("answer"));
                quizList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return quizList;
    }

    public static ArrayList<Quiz> searchQuizListByContentId(int content_id) {
        ArrayList<Quiz> quizList = new ArrayList<>();

        String query = "SELECT * FROM quiz WHERE content_id = '" + content_id + "'";

        Quiz obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setA(rs.getString("a"));
                obj.setB(rs.getString("b"));
                obj.setC(rs.getString("c"));
                obj.setD(rs.getString("d"));
                obj.setAnswer(rs.getString("answer"));
                quizList.add(obj);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return quizList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
