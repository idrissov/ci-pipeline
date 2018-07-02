FROM tomcat
COPY api/target/api.war webapps/
COPY api/src/main/resources/tomcat-users.xml conf/
EXPOSE 8080
CMD catalina.sh run