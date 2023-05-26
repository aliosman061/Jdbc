import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();


        //1. Örnek:  region_id'si 1 olan "country_name" değerlerini çağırın.;
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1);//true ==> DQL ile data çağırıyoruz

        //Datayı çağırıp okumak için executeQuery methodunu kullanmalıyız. execute() methodu sadece tru yada false döner
        ResultSet resultSet = statement.executeQuery(sql1);

        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }


        System.out.println("-------------2.soru-------------------");
        // 2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2 = "select country_id, country_name from countries where region_id>2";
        ResultSet resultSet1    =statement.executeQuery(sql2);

        while (resultSet1.next()){

            System.out.println(resultSet1.getString(1)+"--"+resultSet1.getString(2));
        }

        System.out.println("---------------3. soru------------------------");
        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

        String sql3=("select * from companies where number_of_employees=(select  min(number_of_employees) from companies )");

        ResultSet resultSet2= statement.executeQuery(sql3);

        while(resultSet2.next()){
            System.out.println(resultSet2.getObject(    1)+"--"+resultSet2.getObject(2)+"--"+resultSet2.getObject(3));
        }

        connection.close();
        statement.close();


    }
}
