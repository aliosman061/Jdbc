import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adım: Driver'a kaydol
        //Class.forName("org.postgresql.Driver");//JDBC 4 sonrası yapmaya gerek yok

        //2. Adım: Database'e bağlan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

        //3. Adım: Statement oluştur.
        Statement statement = connection.createStatement();

        //4. Adım: Query çalıştır
        /*
        execute() methodu DDL(create, drop, alter table) ve DQL(select) ile kullanılır
        1) Eğer execute() methodu DDL ile kullanılırsa hep "false" döner. Çünkü DDL ile data çağrılmaz
        2) Eğer execute() methodu DQL ile kullanılırsa data döndüğünde "true" data dönmediğinde "false" verir.
         */

        //1.Örnek: "workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.0
        String sql1 = "CREATE TABLE workers (worker_id VARCHAR(20), worker_name VARCHAR(20), worker_salary INT)";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1);//false

        //2.Örnek: Table'a worker_address sütunu ekleyin.
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(100)";
        boolean r2 = statement.execute(sql2);
        System.out.println("r2 = " + r2);//false

        //3.Örnek: workers table'ını silin.
        String sql3 = "DROP TABLE workers";
        boolean r3 = statement.execute(sql3);
        System.out.println("r3 = " + r3);//false

        //5. Adım: Bağlantıyı kapat
        connection.close();
        statement.close();


    }
}
