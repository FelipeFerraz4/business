# Use a imagem base do OpenJDK 17
FROM openjdk:17-alpine

# Crie um diretório para o aplicativo
RUN mkdir /app

# Defina o diretório de trabalho como /app
WORKDIR /app

# Copie o arquivo JAR do aplicativo para o contêiner
COPY target/business-0.0.1-SNAPSHOT.jar /app/my-spring-boot-app.jar

# Exponha a porta 8080 para o mundo externo
EXPOSE 8080

# Comando para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "my-spring-boot-app.jar"]
