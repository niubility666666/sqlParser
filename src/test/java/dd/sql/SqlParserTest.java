package dd.sql;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqlParserTest {

    public static void main(String[] args) {
        SqlParserTest test = new SqlParserTest();
        test.testParseSingleSql();
        test.testParseSqlFile();
    }

    @Test
    public void testParseSingleSql() {
        String sql = "SELECT * FROM USERS WHERE AGE > 30 AND SALARY = 50000;";
        SqlInfo info = new MySqlParser().parseInfo(sql);
        System.out.println(info);
    }

    @Test
    public void testParseSqlFile() {
        List<String> sqls = MySqlReader.getInstance().readFromClassPath("dd/comment.sql");
        int i = 1;
        for (String sql : sqls) {
            System.out.println("--------------------------------------");
            System.out.println("[" + i++ + "]" + sql);
            try {
                SqlInfo info = new MySqlParser().parseInfo(sql);
                System.out.println(info);
            } catch (Exception e) {
                System.out.println("SQL parse failure: " + sql);
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void testParseCreateTable(){
        String sql = "CREATE TABLE T1(ID INT)";
        SqlInfo info = new MySqlParser().parseInfo(sql);
        Assertions.assertEquals(SqlType.CREATE_TABLE, info.getSqlType());
        Assertions.assertEquals("t1", info.getObject());
    }

}