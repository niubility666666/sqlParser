package zettabase.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlFileReader {

    public static String loadTextFromClassPath(String filename) {
        try {
            InputStream is = SqlFileReader.class.getClassLoader().getResourceAsStream(filename);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String result = loadText(br);
            br.close();
            isr.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Load SQL file failure: file: " + filename, e);
        }
    }

    public static String loadTextFromFile(String filename) {
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String result = loadText(br);
            br.close();
            fr.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Load SQL file failure: file: " + filename, e);
        }
    }

    public static String loadText(BufferedReader br) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            String result = sb.toString();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> loadSqlFromClassPath(String filename) {
        try {
            InputStream is = SqlFileReader.class.getClassLoader().getResourceAsStream(filename);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            List<String> result = loadSql(br);
            br.close();
            isr.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Load SQL file failure: file: " + filename, e);
        }
    }

    public static List<String> loadSqlFromFile(String filename) {
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            List<String> result = loadSql(br);
            br.close();
            fr.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Load SQL file failure: file: " + filename, e);
        }
    }

    public static List<String> loadSql(BufferedReader br) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            String sqlContent = sb.toString();

            String sqlRegex = "(.*?);\\s*(?!--.*?$)";
            Pattern sqlPattern = Pattern.compile(sqlRegex, Pattern.DOTALL);
            Matcher sqlMatcher = sqlPattern.matcher(sqlContent);
            List<String> sqlList = new ArrayList<>();
            while (sqlMatcher.find()) {
                String sql = sqlMatcher.group(1);
                sqlList.add(sql.trim());
            }
            return sqlList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
