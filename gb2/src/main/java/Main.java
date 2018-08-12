import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement stmt;


    public static void main(String[] args) {
        try {
            connect();

            createTable();

            stmt.execute("DELETE  FROM productTable ");


            for (int i = 0; i < 10; i++) {
                int cost = i * 100;
                int prodID = i * 13 + 43234;
                String sq1 = String.format("INSERT INTO productTable (id,prodid,title,cost)\n" +
                        "VALUES (%s,%s,'PRODUCT%s',%s)", i, prodID, i, cost);
                stmt.execute(sq1);
            }

            while (true) {
                Scanner sc = new Scanner(System.in);
                String command = sc.nextLine();

                if (command.startsWith("/цена")) {
                    String[] tokens = command.split(" ");

                    String sq1 = String.format("SELECT cost FROM productTable WHERE title = '%s'", tokens[1]);
                    try {
                        ResultSet rs = stmt.executeQuery(sq1);
                        if (rs.next()) {
                            System.out.println(rs.getString(1) + "$");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (command.startsWith("/сменитьцену")) {
                    String[] tokens = command.split(" ");
                    String sq1 = String.format("UPDATE productTable SET cost = %s WHERE title = '%s'", tokens[2], tokens[1]);
                    stmt.execute(sq1);
                    System.out.println("Цена товара " + tokens[1] + " изменена на " + tokens[2] + "$");
                }


                if (command.startsWith("/товарыпоцене")) {
                    String[] tokens = command.split(" ");
                    String sq0 = String.format("SELECT count(*) FROM productTable WHERE cost>%s AND cost<%s", tokens[1], tokens[2]);
                    String sq1 = String.format("SELECT title FROM productTable WHERE cost>%s AND cost<%s", tokens[1], tokens[2]);
                    try {


                        ResultSet num = stmt.executeQuery(sq0);
                        int number = 0;
                        if (num.next()) {
                            number = num.getInt(1);
                        }

                        ResultSet rs = stmt.executeQuery(sq1);
                        String firstName = "";
                        if (rs.next()) {
                            firstName = rs.getString(1);
                        }


                        String sq3 = String.format("SELECT id FROM productTable WHERE title = '%s'", firstName);
                        ResultSet firstID = stmt.executeQuery(sq3);
                        int start = 0;
                        if (firstID.next()) {
                            start = firstID.getInt(1);
                        }


                        for (int i = start; i < number + start; i++) {
                            String sq4 = String.format("SELECT title FROM productTable WHERE id = %s", i);
                            ResultSet namer = stmt.executeQuery(sq4);
                            if (namer.next()) {
                                System.out.println(namer.getString(1));
                            }
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void createTable() {
        try {
            stmt.execute("CREATE TABLE productTable (\n" +
                    "    id     INTEGER PRIMARY KEY,\n" +
                    "    prodid INTEGER UNIQUE,\n" +
                    "    title  TEXT,\n" +
                    "    cost   INTEGER\n" +
                    ");\n");
        } catch (SQLException e) {
        }
    }

    public static void connect() throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:DataBase.db");
        stmt = connection.createStatement();

    }

    public static void disconnect() throws SQLException {
        connection.close();
    }
}
