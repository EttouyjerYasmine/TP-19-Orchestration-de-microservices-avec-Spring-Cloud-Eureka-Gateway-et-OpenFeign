### Eureka Server • API Gateway • OpenFeign • Services Client & Voiture

Ce projet met en place une architecture microservices complète basée sur Spring Boot et Spring Cloud, comprenant quatre services principaux :

Eureka Server (service de découverte)

API Gateway (routage et filtrage des requêtes)

Service Client

Service Voiture

Communication inter-microservices via OpenFeign

📂 Structure du projet
TP19/
 ├── eureka-server/
 ├── gateway-service/
 ├── service-client/
 ├── service-voiture/
 └── README.md

## Service Client
Description

Microservice permettant la gestion des clients.
Connecté au service voiture via OpenFeign :

Récupérer la liste des voitures d’un client

Composer un objet ClientResponseDTO contenant les voitures associées

Endpoints principaux

GET /clients

GET /clients/{id}

GET /clients/{id}/voitures (via Feign)

Lancement :
cd service-client
mvn spring-boot:run

🚗 4. Service Voiture
Description

Microservice gérant les voitures.
Exposé via API REST classique.

Endpoints principaux

GET /voitures

GET /voitures/{id}

GET /voitures/client/{idClient}

Lancement
cd service-voiture
mvn spring-boot:run

🔗 Communication entre microservices : OpenFeign

Le service-client utilise un client Feign :

@FeignClient(name = "service-voiture")
public interface VoitureRestClient {
    @GetMapping("/voitures/client/{idClient}")
    List<Voiture> getVoituresByClient(@PathVariable Long idClient);
}

🌐 Exécution de l’architecture complète
Ordre de démarrage obligatoire :

1️⃣ Eureka Server
2️⃣ Service Voiture
3️⃣ Service Client
4️⃣ Gateway

Ensuite, accéder aux APIs via la Gateway :

http://localhost:8888/clients

http://localhost:8888/voitures

🛠️ Technologies utilisées

Java 17+

Spring Boot

Spring Cloud Netflix Eureka

Spring Cloud Gateway

OpenFeign

Maven


📘 Auteur

Yasmine ETTOUYJER
Master Didactique des Sciences & Ingénierie Éducative.
ENS Marrakech – Option Technologies émergentes.

✔️ Objectif pédagogique du TP

Ce TP a pour objectif de maîtriser l’orchestration de microservices :

Enregistrement dynamique via un service Discovery

Communication inter-services via Feign

Centralisation des accès via une API Gateway

Architecture scalable et propre

###
-![3f98011f-e71a-481a-afc3-5ab3dfb7867e](https://github.com/user-attachments/assets/7c6fa53b-827a-43ff-8fec-99057c1b9aef)

-![23a52c04-9b20-43a4-92b7-e130c6b8112e](https://github.com/user-attachments/assets/fdd7a553-21e3-4ecd-8439-e87907cfa1cd)

-![71d61e23-1853-42b7-a060-a696096ffc5d](https://github.com/user-attachments/assets/1a53cfca-0096-4635-90f9-b51d6e6fa803)



![de769d1f-c3a2-4de8-84ad-83c7467b859a](https://github.com/user-attachments/assets/7e09903c-b12f-4bdb-9a87-af1881080358)

