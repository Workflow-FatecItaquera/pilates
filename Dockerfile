# Usa uma imagem base com Java 17 (oficial da Eclipse Temurin)
FROM eclipse-temurin:17-jdk-jammy

# Diretório de trabalho dentro do container
WORKDIR /src

# Copia os arquivos necessários para o build
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Baixa as dependências (cacheável)
RUN ./mvnw dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila o projeto e gera o JAR
RUN ./mvnw package -DskipTests

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "target/pilates-pi-0.0.1-SNAPSHOT.jar"]  