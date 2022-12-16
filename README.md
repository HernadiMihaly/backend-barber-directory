# BackendBarbersDirectory-
Barbers Directory is a small school project which was written in Java/Spring Boot (backend) and Angular (frontend).
This repo is the backend part of the project.

The frontend part can be found there: https://github.com/HernadiMihaly/FrontendBarbersDirectory

The project is a REST API which contains:
- CRUD operations
- UI
- Spring Security for authentication and authorization -> login, register system -> only users with Role User can access the /barber path.
- MySQL DB connection
- ManyToOne - OneToMany relationship between the Barber and User tables
