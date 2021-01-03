01-HelloMyBatis:第一个入门的MyBatis例子
一. 实现步骤:
1. 新建student表
    CREATE TABLE `student` (
        `id` int(11) NOT NULL ,
         `name` varchar(255) DEFAULT NULL,
        `email` varchar(255) DEFAULT NULL,
        `age` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
2. 添加项目依赖
    <!--mybatis依赖 -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.1</version>
    </dependency>
    <!--mysql驱动依赖 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.9</version>
    </dependency>
3. 添加资源扫描器插件
    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
4. 设置MyBatis输出日志
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING" />
    </settings>
5. 创建实体类Student[用于保存表中的一行数据]
6. 创建持久层的dao接口[用于定义操作数据库的方法]
7. 创建dao接口的SQL映射文件[一张表对应一个SQL映射文件]
8. 创建mybatis的主配置文件[一个项目对应一个主配置文件]
9. 创建测试类[通过mybatis访问数据库]
    1) 获取SqlSession对象
    2) 获取Sql语句
    3) 执行Sql语句
    4) 关闭SqlSession对象