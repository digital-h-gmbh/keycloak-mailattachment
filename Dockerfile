FROM quay.io/keycloak/keycloak:15.0.2

COPY mailattachment/target/*.jar /opt/jboss/keycloak/modules/org/keycloak/email/provider/main/
COPY mailattachment/module.xml /opt/jboss/keycloak/modules/org/keycloak/email/provider/main/

COPY mailattachment/startup-scripts/* /opt/jboss/startup-scripts/

EXPOSE 8080
ENTRYPOINT [ "/opt/jboss/tools/docker-entrypoint.sh" ]

CMD ["-b", "0.0.0.0"]
