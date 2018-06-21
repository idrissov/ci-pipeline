FROM tomcat
COPY api/target/api.war webapps/
COPY api/src/main/resources/tomcat-users.xml conf/
CMD catalina.sh run
EXPOSE 8080