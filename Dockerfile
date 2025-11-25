# Base Java fiable et disponible
FROM eclipse-temurin:21-jdk

# Crée un dossier pour l'application
WORKDIR /app

# Copie le jar compilé dans le conteneur
COPY target/PersonnelApp.jar /app/PersonnelApp.jar

# Volume pour conserver les données JSON
VOLUME ["/app/data"]

# Commande pour lancer l'application
CMD ["java", "-jar", "PersonnelApp.jar"]
