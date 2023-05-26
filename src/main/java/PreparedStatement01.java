import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        Statement statement = connection.createStatement();
        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
        //PreparedStatement oluşturmak için:

        //1. Adım: PreparedStatement query'sini oluştur
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";//? ==> parametrelendirme

        //2. Adım:PreparedStatement objesi oluştur
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);

        //3. Adım: preparedStatement objesi ile setInt gibi methodlarla soru işaretleri yerlerinie koymak istediğimiz değerleri yerleştiriyoruz.
        preparedStatement.setInt(1,9999);
        preparedStatement.setString(2,"IBM");

        //4. Adım: Query'yi çalıştır
        int guncellenenSatirSayisi = preparedStatement.executeUpdate();
        System.out.println("guncellenenSatirSayisi = " + guncellenenSatirSayisi);

        //Güncelleme sonrası yeni table'ı okuyalım:
        String sql2="SELECT * from companies";
        ResultSet resultSet= statement.executeQuery(sql2);

        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"--"+resultSet.getObject(2)+"--"+resultSet.getObject(3));

        }

        //2. Örnek: Prepared statement kullanarak company adı CASPER olan number_of_employees değerini 5000 olarak güncelleyin.

        System.out.println("2.soru**********");
        preparedStatement.setInt(1,5000);
        preparedStatement.setString(2,"CASPER");
        int updateSayısı= preparedStatement.executeUpdate();
        System.out.println("updateSayısı = " + updateSayısı);


        ResultSet resultSet2= statement.executeQuery(sql2);

        while (resultSet2.next()){
            System.out.println(resultSet2.getObject(1)+"--"+resultSet2.getObject(2)+"--"+resultSet2.getObject(3));

        }


        connection.close();
        statement.close();

    }


}



