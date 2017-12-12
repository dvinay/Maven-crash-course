## Maven Crash Course ##

1) Maven is a Project Management Tool
compile -> Run Tests -> Packaging Jar/Package War -> Deploy to Server
e.g tools like Maven : Ant, Gradle

2) It uses Convention over Configuration

3) How to create a Maven project using command prompt

mvn archetype:generate -DgroupId=com.fuppino -DartifactId=hellomaven -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

(or)
mvn archetype:generate
select 1095 for mvn archetype:generate
it will ask archetype and grouid etc information

//it creates a simple application structure and a sample helloworld java file with name App.java

4) groupId, artifactId, packaging, version are called maven co-ordinates

5) how to build the maven project using command prompt
	go to project -> run the following command

mvn install
//it creates a folder called target and put the .jar / .war file and the class files in classes folder

6) cd classes -> java com/fuppino/App
(or)
7) java -cp target/hellomaven-1.0-SNAPSHOT.jar com.fuppino.App

8) Maven plugin is a collection of one or more goals
e.g: install plugin, it run the compile, test, package goals 

9) How to add maven build plugin to take java1.8 version

maven defaultly take, JDK 1.5 version
go to pom.xml and add the following build plugin to update the project to take jdk version 1.8

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

10) How to create a maven project in eclipse
create a new project -> select Maven project for to create a maven 
and provide the coordinate values

11) How to skip test in maven project using command prompt
mvn install -DskipTests

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
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>4.3.3.RELEASE</version>
	</dependency>
e.g for servlet:
<dependency>
    <groupId>org.apache.geronimo.specs</groupId>
    <artifactId>geronimo-servlet_3.0_spec</artifactId>
    <version>1.0</version>
    <scope>provided</scope>
</dependency>

14) by using maven, you can create multi module project
it's like a one container contains multiple sub-modules/sub-projects

15) while creating multi module project
	create a pom.xml in the root folder 
	give a artifactId
	change packaging type as pom
	remove any dependecies or build
	define modules
	e.g: 
		<modules>
			<module>productservice</module>
			<module>productweb</module>
		</modules>

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
	<groupId>com.fuppino.product</groupId>
  	<artifactId>productparent</artifactId>
  	<version>1.0</version>
  	<packaging>pom</packaging>
  
  	<modules>
  		<module>productservices</module>
  		<module>productweb</module>
  	</modules>

17-A) In child projects add parent tag
	1) create parent project
	2) add parent groupid,artifactid and parent pom version
	3) add child artifactid and packaging

	e.g: //the final pom.xml file after adding the parent project tag to productservice
	<parent>
		<groupId>com.fuppino.product</groupId>
		<artifactId>productparent</artifactId>
		<version>1.0</version>
	</parent>
	
	<artifactId>productservices</artifactId>
	<packaging>jar</packaging>

17-B) for the second project add parent tag
	//do the same steps as 17-A.

	e.g: //the final pom.xml file after adding the parent project tag to productweb
	<parent>
		<groupId>com.fuppino.product</groupId>
		<artifactId>productparent</artifactId>
		<version>1.0</version>
	</parent>
	<artifactId>productweb</artifactId>
	<packaging>war</packaging>
	<name>productweb Maven Webapp</name>

