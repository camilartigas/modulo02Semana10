# Usa a imagem base do OpenJDK 11
FROM openjdk:11-jre-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação Spring Boot para o diretório de trabalho no contêiner
COPY src/main/java/com/example/API/News/ApiNewsApplication.java /app/ApiNewsApplication.jar

# Expõe a porta em que sua aplicação Spring Boot está rodando
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "ApiNewsApplication.jar"]

