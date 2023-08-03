package zettabase;

import java.util.List;

import io.trino.sql.parser.StatementSplitter;

public class SqlParserTest {

    public static void main(String[] args) {
        SqlParserTest.testSqlParser();
        SqlParserTest.testStatementSplit();
    }

    public static void testStatementSplit() {
        String file = "zettabase.sql";
        String text = SqlFileReader.loadTextFromClassPath(file);
        StatementSplitter splitter = new StatementSplitter(text);
        List<StatementSplitter.Statement> statements = splitter.getCompleteStatements();
        String part = splitter.getPartialStatement();
        int i = 1;
        for (StatementSplitter.Statement stmt : statements) {
            System.out.println("--------------------------------------");
            System.out.println("[" + i++ + "]" + stmt);
            try {
                SqlInfo info = new ZettaBaseSqlParser().parseInfo(stmt.statement());
                System.out.println(info);
            } catch (Exception e) {
                System.out.println("SQL parse failure: " + stmt.statement());
                System.out.println(e.getMessage());
            }
        }
    }

    public static void testSqlParser() {
        String sql = "create schema public.s5";
        sql = "SELECT * FROM USERS WHERE AGE > 30 AND SALARY = 50000";
        SqlInfo info = new ZettaBaseSqlParser().parseInfo(sql);
        System.out.println(info);
    }
}