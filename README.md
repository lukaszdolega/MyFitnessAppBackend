# MyFitnessApp
MyFitnessApp is a web application designed to help users with their fitness training. It provides various features such as training management, transformations tracking, and a chat interface powered by AI.

# Overview
## Youtube
https://www.youtube.com/watch?v=HHqug-utwFI

## Heroku
https://my-fitness-app-frontend-15ee72b9447f.herokuapp.com/home

## Admin panel
username: admin
password: test
https://my-fitness-app-frontend-15ee72b9447f.herokuapp.com/admin

## MyFitnessApp is built using the following technologies and frameworks:

- Java
- Spring Boot
- Spring Security
- Hibernate
- JWT
- MySQL
- OpenAI GPT-3.5 Turbo
  
## Installation
- Clone the repository.
- Set up a MySQL database and configure the connection in the application.properties file.
- Obtain an API key from OpenAI and replace the placeholder value in the application.properties file.
- Build the project using Maven.
- Run the application by executing the command `mvn spring-boot:run`.

## API Endpoints
### Training Endpoints
- GET /trainings: Retrieves a paginated list of training programs.
- POST /trainings: Creates a new training program.
- GET /trainings/{slug}: Retrieves a training program by its slug.
### Review Endpoints
- POST /reviews: Adds a new review to a training program.
### Transformation Endpoints
- GET /transformations: Retrieves a paginated list of user transformations.
- GET /transformations/{id}: Retrieves a user transformation by its ID.
- POST /transformations: Creates a new user transformation.
- POST /transformations/upload-image: Uploads an image for a user transformation.
- GET /data/images/{filename}: Retrieves the uploaded image file.
### User Authentication Endpoints
- POST /login: Authenticates a user and generates a JWT token.
- POST /register: Registers a new user.
### Lost Password Endpoints
- POST /lostPassword: Sends a lost password email to the user.
- POST /changePassword: Changes the user's password.

### Admin Endpoints
- GET /admin/categories: Retrieves a list of categories for admin management.
- GET /admin/categories/{id}: Retrieves a category by its ID for admin management.
- POST /admin/categories: Creates a new category for admin management.
- PUT /admin/categories/{id}: Updates a category by its ID for admin management.
- DELETE /admin/categories/{id}: Deletes a category by its ID for admin management.

- GET /admin/reviews: Retrieves a list of reviews for admin management.
- PUT /admin/reviews/{id}/moderate: Moderates a review by its ID for admin management.
- DELETE /admin/reviews/{id}: Deletes a review by its ID for admin management.

- GET /admin/trainings: Retrieves a paginated list of trainings for admin management.
- GET /admin/trainings/{id}: Retrieves a training by its ID for admin management.
- POST /admin/trainings: Creates a new training for admin management.
- PUT /admin/trainings/{id}: Updates a training by its ID for admin management.
- DELETE /admin/trainings/{id}: Deletes a training by its ID for admin management.


## Security
The application uses JWT (JSON Web Tokens) for authentication and authorization. User passwords are stored securely using bcrypt encryption. The endpoints are secured using Spring Security to ensure proper access control.


## Author
This application was created by Łukasz Dołęga.
