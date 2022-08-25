
# Keycloak SPI to send emails with attachment

## getting started

```shell
cd mailattachment
mvn clean install

cd ..
docker-compose up
```


Currently, you will get an error like: 
```
keycloak_1  | 15:29:01,292 FATAL [org.keycloak.services] (ServerService Thread Pool -- 60) Error during startup: java.lang.RuntimeException: org.jboss.modules.ModuleLoadException: Error loading module from /opt/jboss/keycloak/modules/org/keycloak/email/provider/main/module.xml
...
keycloak_1  | Caused by: org.jboss.modules.xml.XmlPullParserException: Invalid/mismatched module name (expected org.keycloak.email) (position: START_TAG seen ...?>\n<module xmlns="urn:jboss:module:1.1" name="org.keycloak.email">... @2:64) 
...
```

## Goal
* [ ] send a pdf-file as attachment with the registration verification mail.
* [ ] the pdf-file should be applied only to certain realms. Not all realms.
