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
