package zettabase.sql;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.trino.sql.tree.Node;
import io.trino.sql.tree.QualifiedName;

public class SqlInfo {

    private SqlType sqlType;
    private String catalog;
    private String schema;
    private String object;

    private Node astTree;

    private QualifiedName name;
    private String nameType = "object";

    private Set<String> objects = new HashSet<>();

    @Override
    public String toString() {
        return "SqlInfo{" +
            "type='" + sqlType + '\'' +
            ", name='" + name + '\'' +
            ", catalog='" + getCatalog() + '\'' +
            ", schema='" + getSchema() + '\'' +
            ", object='" + getObject() + '\'' +
            ", objects=" + objects +
            '}';
    }

    public SqlType getSqlType() {
        return sqlType;
    }

    public void setSqlType(SqlType sqlType) {
        if (this.sqlType == null) {
            this.sqlType = sqlType;
        }
    }

    public String getCatalog() {
        if (name != null) {
            List<String> parts = name.getParts();
            if (nameType.equals("object")) {
                if (parts.size() == 3) {
                    return parts.get(0);
                } else {
                    return null;
                }
            } else if (nameType.equals("schema")) {
                if (parts.size() == 2) {
                    return parts.get(0);
                } else {
                    return null;
                }
            } else if (nameType.equals("catalog")) {
                if (parts.size() == 1) {
                    return parts.get(0);
                } else {
                    return null;
                }
            }
        }
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSchema() {
        if (name != null) {
            List<String> parts = name.getParts();
            if (nameType.equals("object")) {
                switch (parts.size()) {
                    case 2:
                        return parts.get(0);
                    case 3:
                        return parts.get(1);
                    default:
                        return null;
                }
            } else if (nameType.equals("schema")) {
                switch (parts.size()) {
                    case 1:
                        return parts.get(0);
                    case 2:
                        return parts.get(1);
                    default:
                        return null;
                }
            }
        }
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getObject() {
        if (name != null && nameType.equals("object")) {
            List<String> parts = name.getParts();
            switch (parts.size()) {
                case 1:
                    return parts.get(0);
                case 2:
                    return parts.get(1);
                case 3:
                    return parts.get(2);
                default:
                    return null;
            }
        }
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Set<String> getObjects() {
        return objects;
    }

    public void setObjects(Set<String> objects) {
        this.objects = objects;
    }

    public Node getAstTree() {
        return astTree;
    }

    public void setAstTree(Node astTree) {
        this.astTree = astTree;
    }

    public QualifiedName getName() {
        return name;
    }

    public void setName(QualifiedName name) {
        this.name = name;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
