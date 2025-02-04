# Usa una imagen base de OpenJDK con JRE optimizado
FROM openjdk:17-jdk-slim
LABEL maintainer="Enrqiue Mares Mendoza"
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
EXPOSE 8081
ENV PRODUCTO_PORT 8081
ENV PRODUCTO_URI mongodb+srv://enriquemarestcp:Lodeons1234@cluster0.cv2so.mongodb.net/productos
ENV PRODUCTO_DB productos
ENV PRODUCTO_US enriquemarestcp
ENV PRODUCTO_PS Lodeons1234
ARG JAR_FILE=target/*.jar 
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
