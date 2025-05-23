FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copia os arquivos do Maven Wrapper e dá permissão de execução
COPY .mvn/ .mvn
COPY mvnw .
RUN chmod +x mvnw

# Copia o POM e baixa as dependências
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copia o código e faz o build
COPY src ./src
RUN ./mvnw package -DskipTests

# Comando para rodar
ENTRYPOINT ["java", "-jar", "target/pilates-pi-0.0.1-SNAPSHOT.jar"]