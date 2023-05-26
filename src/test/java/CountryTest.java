import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CountryTest {
    /*
     Given
       User connects to the database
       (Kullanıcı veritabanına bağlanır)

     When
       User sends the query to get the region ids from "countries" table
       (Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )

     Then-->Çoklu işlem
       Assert that the number of region ids greater than 1 is 17.
       (1'den büyük region id'lerin sayısının 17 olduğunu doğrula )

     And
       User closes the connection
    */
    @Test
    public void countryTest() throws SQLException {
        //(Kullanıcı veritabanına bağlanır)
        JDBCUtils.connectToDataBase();
        JDBCUtils.createStatement();


        //(Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )
        String sql = "select count(region_id) from countries where region_id >1;";
        ResultSet resultSet = JDBCUtils.executeQuery(sql);

        //(1'den büyük region id'lerin sayısının 17 olduğunu doğrula )
        int number = 0;
        while (resultSet.next()) {
            number = resultSet.getInt(1);
        }

        assertEquals(17, number);
        JDBCUtils.closeConnection();
    }
        @Test
        public void countryTest02() throws SQLException {
            //(Kullanıcı veritabanına bağlanır)
            JDBCUtils.connectToDataBase();
            JDBCUtils.createStatement();


            //(Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )
            String sql="select region_id from countries where region_id >1;";
            ResultSet resultSet = JDBCUtils.executeQuery(sql);

            List<Integer> region_idList = new ArrayList<>();

            while (resultSet.next()) {
                region_idList.add(resultSet.getInt("region_id"));
            }

            System.out.println("region_idList = " + region_idList);//region_idList = [2, 3, 2, 2, 3, 4, 4, 3, 3, 4, 3, 2, 4, 3, 2, 4, 4]

            assertEquals(17, region_idList.size());

            //kapatma
            JDBCUtils.closeConnection();
        }







    }

