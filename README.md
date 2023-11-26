# bankomat
Eine Webanwendung auf Jakarta EE Basis, die eingegebene Beträge in Scheine und Münzen stückelt.

# Routen
## Hauptanwendung
Die Hauptanwendung ist unter dem Kontext **/bankomat** erreichbar. Bei einem Default Deployment aus der Entwicklungsumgebung heraus also z. B. *http://localhost:8080/bankomat*
## Swagger
Das Swagger UI für die Dokumentation der REST-Api ist under **/bankomat/swagger** erreichbar. Bei einem Default Deployment aus der Entwicklungsumgebung heraus also z. B. *http://localhost:8080/bankomat/swagger*. **Wichtiger Hinweis**: Aktuell lädt Swagger die Dokumentation nach dem ersten Serverstart nicht beim ersten Aufruf. Die Seite noch einmal zu laden funktioniert aktuell als Workaround.
## REST-API
Für direkte Http Zugriffe ist das REST-API unter **/bankomat/restapi/stueckelung** erreichbar. Der zu stückelnde Wert wird als Parameter übergeben. Ein Beispielaufruf sieht wie folgt aus: *http://localhost:8080/bankomat/restapi/stueckelung?value=130*

# Lauffähigkeit
Die Anwendung wurde mit folgenden Komponenten getestet:
- Widfly 30
- Java 20
- Firefox 120.0
