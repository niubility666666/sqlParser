package zettabase.sql;

import java.util.ArrayList;
import java.util.List;

import io.trino.sql.parser.StatementSplitter;

public class ZettaBaseSqlReader {

    private static final ZettaBaseSqlReader instance = new ZettaBaseSqlReader();

    public static ZettaBaseSqlReader getInstance() {
        return instance;
    }

    public List<String> readFromText(String sqlText) {
        StatementSplitter splitter = new StatementSplitter(sqlText);
        List<StatementSplitter.Statement> statements = splitter.getCompleteStatements();
        String part = splitter.getPartialStatement();
        List<String> result = new ArrayList<>();
        for (StatementSplitter.Statement stmt : statements) {
            result.add(stmt.statement());
        }
        if (!part.isBlank()) {
            result.add(part);
        }
        return result;
    }

    public List<String> readFromFile(String filename) {
        String text = SqlFileReader.loadTextFromFile(filename);
        return readFromText(text);
    }

    public List<String> readFromClassPath(String filename) {
        String text = SqlFileReader.loadTextFromClassPath(filename);
        return readFromText(text);
    }
}
