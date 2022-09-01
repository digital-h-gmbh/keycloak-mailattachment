build:
	mvn package -f "pom.xml" && \
	docker build -t auth-service .

start:
	docker-compose up
