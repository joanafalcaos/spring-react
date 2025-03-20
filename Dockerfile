# Use uma imagem com Gradle e JDK instalados
FROM gradle:8.4-jdk17 AS builder

# Diretório de trabalho no container
WORKDIR /app

# Copia os arquivos para o container
COPY . .

# Permite execução do Gradle Wrapper
RUN chmod +x ./gradlew

# Resolve dependências para evitar cache em mudanças futuras
RUN ./gradlew dependencies

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar em modo desenvolvimento (hot reload)
CMD ["./gradlew", "bootRun"]
