# HuskyCore  

MC工具插件  
提供了一些工具方法，方便开发者使用

## 使用方法  
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
---
```xml
<dependencys>
    <dependency>
        <groupId>com.github.YDHusky</groupId>
        <artifactId>HuskyCore</artifactId>
        <version>HuskyCore-1.1</version>
    </dependency>
</dependencys>
```

## 工具方法
- 字符串工具([StringUtil](src/main/java/org/siberianhusky/huskycore/utils/StringUtils.java))
- 发送消息工具([SendMessage](src/main/java/org/siberianhusky/huskycore/utils/SendMessage.java))
- SQLite数据库工具([SQLite](src/main/java/org/siberianhusky/huskycore/utils/sqlite/SqliteHelper.java))
- Mysql数据库工具([Mysql](src/main/java/org/siberianhusky/huskycore/utils/mysql/SqlHelper.java))
- GUI创建工具([CreateGUI](src/main/java/org/siberianhusky/huskycore/utils/gui/CreateGUI.java))
- 文件工具([FileUtil](src/main/java/org/siberianhusky/huskycore/utils/file/CreateFile.java))
## 接口规范
- 注册事件及指令([Register](src/main/java/org/siberianhusky/huskycore/api/Register.java))
- 文件加载([LoadConfig](src/main/java/org/siberianhusky/huskycore/api/LoadConfig.java))
- GUI([GUI](src/main/java/org/siberianhusky/huskycore/api/GUI.java))