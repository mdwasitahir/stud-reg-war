# stud-reg-war
A Simple Java based Web App with a registration page and the result page. It is developed using Spring Boot. It should be built using Maven. It is a simple Web App to demonstrate the use of Maven Build Tool.  It packages a .war artifact.

# For Amazon Linux 2023
- Launch instance using Amazon Linux 2023 AMI
- Install Java 17, Maven and Git
  ```
  sudo yum update -y
  sudo yum install java-17-amazon-corretto-devel -y
  sudo yum install maven -y
  sudo yum install git -y
  sudo yum install tomcat10 -y
  ```
- Clone the repo `git clone https://github.com/devopstraining611-282/stud-reg-war.git`
- Go to the repo directory `cd stud-reg-war`
- Build the project `mvn clean package`
- It will build and create the package war file named "**stud-reg-war-0.0.1-SNAPSHOT.war**"
- Deploy the war package in the Tomcat Server's deployment directory "**webapps**" using the command "**cp target/stud-reg-war-0.0.1-SNAPSHOT.war /var/lib/tomcat10/webapps**"
- Access in the browser using the url "**http://<EC2_Public_IP_or_DNS>:8080/stud-reg-war-0.0.1-SNAPSHOT**"

# For Ubuntu Server 24.04 LTS
- Launch instance using Ubuntu Server 24.04 LTS
- Install Java 17, Maven and Git
  ```
  sudo apt-get update
  sudo apt-get install openjdk-17-jdk -y
  sudo apt-get install maven -y
  sudo apt-get install git -y
  sudo apt-get install tomcat10 -y
  ```
- Clone the repo `git clone https://github.com/devopstraining611-282/stud-reg-war.git`
- Go to the repo directory `cd stud-reg-war`
- Build the project `mvn clean package`
- It will build and create the package war file named "**stud-reg-war-0.0.1-SNAPSHOT.war**"
- Deploy the war package in the Tomcat Server's deployment directory "**webapps**" using the command "**cp target/stud-reg-war-0.0.1-SNAPSHOT.war /var/lib/tomcat10/webapps**"
- Access in the browser using the url "**http://<EC2_Public_IP_or_DNS>:8080/stud-reg-war-0.0.1-SNAPSHOT**"
