set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllure\*;%ProjectPath%libExtentV5\*;%ProjectPath%libLog4J\*;%ProjectPath%libWebDriverManager\*;%ProjectPath%libReportNG\*;%ProjectPath%libSelenium\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceAdmin.xml"
pause