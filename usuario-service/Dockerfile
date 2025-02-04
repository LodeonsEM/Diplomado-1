FROM openjdk:17-oracle
LABEL maintainer="Enrqiue Mares Mendoza"
EXPOSE 8081
ENV PRODUCTO_PORT 8081
ENV PRODUCTO_URI mongodb+srv://enriquemarestcp:Lodeons1234@cluster0.cv2so.mongodb.net/usuarios
ENV PRODUCTO_DB usuarios
ENV PRODUCTO_US enriquemarestcp
ENV PRODUCTO_PS Lodeons1234
ARG JAR_FILE=target/*.jar
COPY target/*.jar usuario.jar
CMD ["java", "-jar", "/usuario.jar"]

