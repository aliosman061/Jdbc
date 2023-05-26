public class Runner {
    public static void main(String[] args) {

        //database bağlanma
        JDBCUtils.connectToDataBase();

        //statement oluştur
        JDBCUtils.createStatement();

        //query çalıştır
        String sql="CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);";
        JDBCUtils.execute(sql);
    }

}
