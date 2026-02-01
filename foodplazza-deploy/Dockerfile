FROM tomcat:9-jdk11

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR to Tomcat
COPY ROOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose Railway port
EXPOSE 8080

CMD ["catalina.sh", "run"]
