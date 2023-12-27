package dd.sql;

public enum SqlType {
    CREATE_SCHEMA,
    CREATE_TABLE,
    CREATE_TABLE_AS_SELECT,
    CREATE_TABLE_LIKE,
    CREATE_VIEW,
    CREATE_USER,
    CREATE_ROLE,
    DROP_SCHEMA,
    DROP_TABLE,
    DROP_VIEW,
    DROP_USER,
    DROP_ROLE,
    INSERT,
    INSERT_INTO,
    SELECT,
    REPLACE,
    UPDATE,
    UPDATE_ASSIGNMENT,
    DELETE,
    UPSERT,
    USE,
    ALTER_SCHEMA,
    ALTER_TABLE,

    SET_SCHEMA_AUTHORIZATION,
    SET_TABLE_AUTHORIZATION,
    SET_VIEW_AUTHORIZATION,

    SET_PATH,
    SET_TIMEZONE,

    SET_TABLE_PROPERTIES,
    SET_MATERIALIZED_VIEW_PROPERTIES,

    CREATE_MATERIALIZED_VIEW,
    REFRESH_MATERIALIZED_VIEW,
    DROP_MATERIALIZED_VIEW,

    SHOW_CATALOGS,
    SHOW_SCHEMAS,
    SHOW_TABLES,
    SHOW_COLUMNS,
    SHOW_STATS,
    SHOW_STATS_FOR_QUERY,
    SHOW_FUNCTIONS,

    SHOW_SESSION,
    SET_SESSION,
    RESET_SESSION,

    SHOW_CREATE_SCHEMA,
    SHOW_CREATE_TABLE,
    SHOW_CREATE_VIEW,
    SHOW_CREATE_MATERIALIZED_VIEW,

    TRUNCATE_TABLE,

    MERGE,
    MERGE_INSERT,
    MERGE_UPDATE,
    MERGE_DELETE,

    COMMENT_TABLE,
    COMMENT_VIEW,
    COMMENT_COLUMN,

    ANALYZE,

    RENAME_SCHEMA,
    RENAME_TABLE,
    RENAME_COLUMN,
    RENAME_VIEW,
    RENAME_MATERIALIZED_VIEW,

    ADD_COLUMN,
    DROP_COLUMN,

    TABLE_EXECUTE,

    START_TRANSACTION,
    COMMIT,
    ROLLBACK,

    SET_TRANSACTION_ACCESS_MODE,
    SET_ISOLATION_LEVEL,

    CALL,
    PREPARE,
    DEALLOCATE,
    EXECUTE,
    DESCRIBE_INPUT,
    DESCRIBE_OUTPUT,

    WITH,
    UNION,
    INTERSECT,
    EXCEPT,

    EXPLAIN,
    EXPLAIN_ANALYZE,

    GRANT,
    GRANT_ROLES,
    REVOKE,
    REVOKE_ROLES,
    SET_ROLE,
    DENY,
    SHOW_GRANTS,
    SHOW_ROLES,
    SHOW_ROLE_GRANTS,

    QUERY,
    NAMED_QUERY,
    QUERY_NO_WITH,
    QUERY_SPECIFICATION,

}