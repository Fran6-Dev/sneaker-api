# Sneaker API 🥿

API REST Spring Boot pour la gestion d'une boutique de sneakers.

## Stack technique

- Java 25
- Spring Boot 3.5.16
- Spring Security + JWT
- Spring Data JPA / Hibernate
- H2 Database (dev)
- Lombok
- Maven

## Architecture

src/main/java/com/francis/sneaker_api/

├── config/         # Spring Security, JWT

├── controller/     # Endpoints REST

├── service/        # Logique métier

├── repository/     # Accès BDD

├── model/          # Entités JPA

├── dto/            # Objets de transfert

├── exception/      # Exceptions custom

└── handler/        # Gestion globale des erreurs

## Endpoints

### Auth (public)
| Méthode | Endpoint | Description |
|---------|----------|-------------|
| POST | /auth/register | Créer un compte |
| POST | /auth/login | Se connecter |

### Products (authentifié)
| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | /products | Liste tous les produits |
| GET | /products/{id} | Récupère un produit |
| POST | /products | Crée un produit |
| PUT | /products/{id} | Modifie un produit |
| DELETE | /products/{id} | Supprime un produit |

## Lancer le projet

```bash
./mvnw spring-boot:run
```

## Authentification

1. Créer un compte via `POST /auth/register`
2. Se connecter via `POST /auth/login` → récupérer le token
3. Ajouter le token dans le header de chaque requête :
## Exemple de requête

### Register
```json
POST /auth/register
{
    "username": "francis",
    "password": "password123",
    "role": "ROLE_USER"
}
```

### Créer un produit
```json
POST /products
Authorization: Bearer <token>

{
    "name": "Air Jordan 1",
    "brand": "Nike",
    "price": 180.0,
    "stock": 10,
    "description": "Sneaker iconique"
}
```