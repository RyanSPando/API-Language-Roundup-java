package donuttycoon;

import java.sql.Connection;
import donuttycoon.Donut;
import donuttycoon.Db;
import java.util.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonutService {

    public List<Donut> getAllDonuts() {

      Map<String, Donut> donuts1 = new HashMap<String,Donut>();
      try {
        Connection conn = Db.Db();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM donut;" );
        while (rs.next()) {

          int id = rs.getInt("id");
          String stringedId = Integer.toString(id);
          String name = rs.getString("name");
          String topping = rs.getString("topping");
          int price = rs.getInt("price");

          Donut donut1 = new Donut(stringedId, name, topping, price);
          donuts1.put(stringedId, donut1);
        }
        stmt.close();
        conn.close();
      }
      catch (SQLException e) {
      	System.out.println("Connection Failed! Check output console");
      	e.printStackTrace();
      }
        return new ArrayList<Donut>(donuts1.values());
    }

    public Donut getDonut(String id) {

      int idInt = 0;
      String stringedId = null;
      String name = null;
      String topping = null;
      Integer price = 0;

      try {
        Connection conn = Db.Db();
        Statement stmt = conn.createStatement();

        String sql = "Select * from donut where ID=" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
          idInt = rs.getInt("id");
          stringedId = Integer.toString(idInt);
          name = rs.getString("name");
          topping = rs.getString("topping");
          price = rs.getInt("price");
        }

        stmt.close();
        conn.close();
      }
      catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
      }
      Donut donut = new Donut(stringedId, name, topping, price);
      return donut;
    }

    public Donut createDonut(String name, String topping, Integer price) {
        failIfInvalid(name, topping, price);
        int id = 0;
        String stringedId = "0";

        try {
          Connection conn = Db.Db();
          Statement stmt = conn.createStatement();

          String sql = "INSERT INTO donut (name, topping, price)" + " VALUES ('" + name + "', '" + topping + "', " + Integer.toString(price) + ") RETURNING *;";
          ResultSet rs = stmt.executeQuery(sql);

          while (rs.next()) {
            id = rs.getInt("id");
            stringedId = Integer.toString(id);
            name = rs.getString("name");
            topping = rs.getString("topping");
            price = rs.getInt("price");
          }

          stmt.close();
          conn.close();
        }
        catch (SQLException e) {
        	System.out.println("Connection Failed! Check output console");
        	e.printStackTrace();
        }
        Donut donut = new Donut(stringedId, name, topping, price);
        return donut;
    }

      public Donut updateDonut(String id, String name, String topping, Integer price) {
        failIfInvalid(name, topping, price);
        int idInt = -1;
        String stringedId = null;

        try {
          Connection conn = Db.Db();
          Statement stmt = conn.createStatement();

          String sql = "UPDATE donut set NAME='" + name + "', TOPPING='" + topping + "', Price=" + price + "where ID=" + id + " RETURNING *;";

          ResultSet rs = stmt.executeQuery(sql);

          while (rs.next()) {
            idInt = rs.getInt("id");
            stringedId = Integer.toString(idInt);
            name = rs.getString("name");
            topping = rs.getString("topping");
            price = rs.getInt("price");
          }

          stmt.close();
          conn.close();
        }
        catch (SQLException e) {
          System.out.println("Connection Failed! Check output console");
          e.printStackTrace();
        }

        Donut donut = new Donut(stringedId, name, topping, price);
        return donut;
    }

    public Donut deleteDonut(String id) {

      int idInt = 0;
      String stringedId = null;
      String name = null;
      String topping = null;
      Integer price = 0;

      try {
        Connection conn = Db.Db();
        Statement stmt = conn.createStatement();

        String sql = "DELETE from donut where ID=" + id + " RETURNING *;";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
          idInt = rs.getInt("id");
          stringedId = Integer.toString(idInt);
          name = rs.getString("name");
          topping = rs.getString("topping");
          price = rs.getInt("price");
        }

        stmt.close();
        conn.close();
      }
      catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
      }
      Donut donut = new Donut(stringedId, name, topping, price);
      return donut;
    }

    private void failIfInvalid(String name, String topping, Integer price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'name' cannot be empty");
        }
        if (topping == null || topping.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'topping' cannot be empty");
        }
        if (price == null) {
            throw new IllegalArgumentException("Parameter 'price' cannot be empty");
        }
    }
}
