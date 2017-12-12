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

14) 