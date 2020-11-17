解析网上的json文件
================
通过gson解析json文件，获取到每天和每七天的天气信息

WEB-INF中的jsp访问外部静态文件
============================
1、需要在头部信息中添加isELIgnored="false"
2、在web.xml中添加
<!-- 处理静态文件可以正常访问 -->
  <servlet-mapping>
      <servlet-name>default</servlet-name>
      <url-pattern>*.jpg</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
      <servlet-name>default</servlet-name>
      <url-pattern>*.png</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
      <servlet-name>default</servlet-name>
      <url-pattern>*.svg</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
      <servlet-name>default</servlet-name>
      <url-pattern>*.js</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
      <servlet-name>default</servlet-name>
      <url-pattern>*.css</url-pattern>
  </servlet-mapping>
3、在springMVC.xml中添加
    <!-- 静态资源可访问的设置方式 -->
	<mvc:default-servlet-handler />


maven中的jdk版本需要改为1.8
=========================
D:\apache-maven-3.6.3\conf\settings.xml中
改为1.8


从jsp中获取href="city?citycode"
==============================
在方法加入HttpServletRequest request
request.getParameter("citycode")


使用java8的lambda表达式的版本问题
===============================
maven会自动编译为jdk1.6的形式
若要使用java8的表达，需要在pom.xml中添加
```
<plugins>
    <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <encoding>UTF-8</encoding>
    </configuration>
    </plugin>
</plugins>
```
其中，version需要使用3.8.0以上，才会编译成jdk1.8

编译执行文件
==========
mvn clean
mvn compile
mvn package
通过tomcat运行

mybatis中的一对一映射
===================
<resultMap type="User" id="Getcitycode">
    <id column="ucity" property="ucity"/>

    <association property="city" javaType="City">
        <id column="ucity" property="cname"/>
        <result column="code" property="code"/>
    </association>
</resultMap>

<select id="getCode" parameterType="String" resultMap="Getcitycode">
    select t1.code, t1.cname, t2.ucity from city t1, message t2 where t1.cname=t2.ucity and t2.uname=#{uname} 
</select>

resultMap中的property值需要对应在sql语句中查询出来
其中association是映射对象，id标签中，column为User中的列，property为有映射关系的另一张表city中的cname列，即sql语句中的where t1.cname=t2.ucity