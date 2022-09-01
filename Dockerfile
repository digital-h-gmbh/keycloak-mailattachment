FROM quay.io/keycloak/keycloak:15.0.2

COPY target/email-0.0.1.jar /opt/jboss/keycloak/standalone/deployments/email.jar

EXPOSE 8080
ENTRYPOINT ["/opt/jboss/tools/docker-entrypoint.sh", "-b", "0.0.0.0"]
