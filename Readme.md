## Maven Crash Course ##

1) Maven is a Project Management Tool
compile -> Run Tests -> Packaging Jar/Package War -> Deploy to Server
e.g tools like Maven : Ant, Gradle

2) It uses Convention over Configuration

3) How to create a Maven project using command prompt

mvn archetype:generate -DgroupId=com.fuppino -DartifactId=hellomaven -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

(or)

mvn archetype:generate
- select 1095 for mvn archetype:generate
- it will ask archetype and grouid etc information
- it creates a simple application structure and a sample helloworld java file with name App.java

4) groupId, artifactId, packaging, version are called maven co-ordinates

5) how to build the maven project using command prompt
	go to project -> run the following command

mvn install
//it creates a folder called target and put the .jar / .war file and the class files in classes folder

6) cd classes -> java com/fuppino/App
(or)
7) java -cp target/hellomaven-1.0-SNAPSHOT.jar com.fuppino.App

8) Maven plugin is a collection of one or more goals, goal can be a specific task. We can refer to plugin and goal like plugInId:goalId
e.g: install plugin, it run the compile, test, package goals 

9) How to add maven build plugin to take java1.8 version

maven defaultly take, JDK 1.5 version
go to pom.xml and add the following build plugin to update the project to take jdk version 1.8

```XML
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.2</version>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>
	</plugins>
</build>
```

10) How to create a maven project in eclipse
create a new project -> select Maven project for to create a maven 
and provide the coordinate values

11) How to skip test in maven project using command prompt
mvn install -DskipTests
Note: to generate test cases for a class, select the class and right click and select new and select test cases.

12) How to skip test in maven project using eclipse

select project -> run as -> run configuration
click maven build -> click +
give configuration -> 
	build name
	browser folder as current project
	goal as install
	click run

13) How to configure other libraries into maven project
go to pom.xml
add the other libraries dependecy tag
e.g for spring:
```XML
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
	<version>4.3.3.RELEASE</version>
</dependency>
```
e.g for servlet:
```XML
<dependency>
    <groupId>org.apache.geronimo.specs</groupId>
    <artifactId>geronimo-servlet_3.0_spec</artifactId>
    <version>1.0</version>
    <scope>provided</scope>
</dependency>
```
14) by using maven, you can create multi module project
it's like a one container contains multiple sub-modules/sub-projects

15) while creating multi module project
	create a pom.xml in the root folder 
	give a artifactId
	change packaging type as pom
	remove any dependecies or build
	define modules
```XML
<modules>
	<module>productservice</module>
	<module>productweb</module>
</modules>
```
16) How to create multi module project in eclipse
	1) create a maven project
	2) select create a simple project(skip archietype selection) and press next
	3) give parent project group id
	4) give parent project artifact id
	5) select version 
	6) select packaging type as pom
	7) select create
	8) go to parent project pom and add modules

	e.g: //the final pom.xml file will be
```XML
	<groupId>com.fuppino.product</groupId>
  	<artifactId>productparent</artifactId>
  	<version>1.0</version>
  	<packaging>pom</packaging>
  
  	<modules>
  		<module>productservices</module>
  		<module>productweb</module>
  	</modules>
```

17-A) In child projects add parent tag
	1) create parent project
	2) add parent groupid,artifactid and parent pom version
	3) add child artifactid and packaging
	e.g: //the final pom.xml file after adding the parent project tag to 
	productservice

```XML	
	<parent>
		<groupId>com.fuppino.product</groupId>
		<artifactId>productparent</artifactId>
		<version>1.0</version>
	</parent>
	
	<artifactId>productservices</artifactId>
	<packaging>jar</packaging>
```
17-B) for the second project add parent tag
	//do the same steps as 17-A.
	e.g: //the final pom.xml file after adding the parent project tag to productweb
```XML
	<parent>
		<groupId>com.fuppino.product</groupId>
		<artifactId>productparent</artifactId>
		<version>1.0</version>
	</parent>
	<artifactId>productweb</artifactId>
	<packaging>war</packaging>
	<name>productweb Maven Webapp</name>
```
18) to build multi module projects, in command line
	go to parent project folder which contains pom.xml type as pom.
	run $mvn install command
	
19) How the project web and project service works
	1) project service is a dependency project for project web
	2) when we run the project service, spring context loads the beans from the sevice bean file
	3) the beans are available in the spring context.
	4) run the project in tomcat
	5) load http://localhost:8080/productweb/product.html
	6) enter the information and press submit

20) How to compile and build the complete multi module project at a time
	1) move all the child modules to inside the parent module
	2) delete the project form eclipse(don't select delete from disk)
	3) import the parent project. It will automatically loads all submodules
	4) select parent project and compile the complete module


21) Maven scope is a visibility of plugins in life cycle
	1) compile - during project build, it's a default scope
	2) provided - test and run, it won't exist in final archive file
		e.g: servlet-api dependency
	3) runtime - only for running the tests, not available for compilation
	4) test - only to compile the tests, run the tests
		e.g: junit
	5) system - the dependency available in the project.
		we have to provide path for lib, related to project sub directory ${basedir}\war\WEB-INF\lib\extDependecy.jar
	6) import - used in pom based project, not for jar or war