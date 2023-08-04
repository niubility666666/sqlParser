ZettaBase SQL Parser

# Usage

ZettaBaseSqlReader
```java
    # 从文本读取sql文本，并分割成多个独立sql，最后一个sql有可能是不完整的
    List<String> sqls = ZettaBaseSqlReader.getInstance().readFromText("create table t1(id int); select * from t1; xxx");
    ...

    # 从Class Path读取sql文件，并分隔成多个独立sql
    List<String> sqls = ZettaBaseSqlReader.getInstance().readFromClassPath("dir/file.sql");
    ...

    # 从文件系统读取sql文件，并分割成多个独立sql
    List<String> sqls = ZettaBaseSqlReader.getInstance().readFromClassPath("dir/file.sql");
    ...
```
ZettaBaseSqlParser
```java
    SqlInfo info = new ZettaBaseSqlParser().parseInfo(sql);
    #sql的类型，如CREATE_TABLE, DROP_TABLE, QUERY等    
    info.getSqlType();
    #如果sql是ddl，或有一个主操作对象，如create table, update, truncate等，主操作对象信息可以通过如下方法获取
    info.getCatalog(); // 可能为空
    info.getSchema();  // 可能为空
    info.getObject();  // 表名，视图名等
    #如果sql是select语句或有select操作(如create table as select, create view as select)，可能涉及多个对象，涉及的对象通过如下方式获取
    info.getObjects(); //目前返回的是FullQulifiedName字符串列表，没有做切分处理
    
```

# 支持的SQL语法
目前使用了trinodb的语法描述文件，未做修改，后续需要提供ZettaBase的语法描述文件

# 实现说明
使用了trinodb的392版本的源码，做了如下修改：
* 提取trinodb-parser子项目
* 修改pom文件，去掉了对trinodb父项目的依赖，补全依赖的版本信息
* 修改io.trino.parser.AstBuilder和ErrorHandler类为public
* 基于AstBuilder Visitor类，实现InfoBuilder Visitor类，用于提取sql类型和sql操作对象信息
* 实现ZettaBaseSqlParser和ZettaBaseSqlReader调用接口