# Trabalho UCS
Criar webservices SOAP e REST em Java de um sistema de universidade a partir do modelo da especificação do trabalho e desenvolver um client para consumir esses webservices

## WebServices
### Áreas
#### SOAP
- `localhost:8080/universidade/areas`
#### REST
- GET `localhost:8080/universidade/rest/areas`: busca todas áreas cadastradas
- POST `localhost:8080/universidade/rest/areas`: criar nova área
- GET `localhost:8080/universidade/rest/areas/{id}`: busca área especificada
- PUTT `localhost:8080/universidade/rest/areas/{id}`: atualizar área especificada
- DELETE `localhost:8080/universidade/rest/areas/{id}`: remover área especificada
- GET `localhost:8080/universidade/rest/areas/{id}/cursos`: busca todos cursos da  área especificada
- GET `localhost:8080/universidade/rest/areas/{id}/disciplinas`: busca todas disciplinas da área especificada
### Cursos
#### SOAP
- `localhost:8080/universidade/cursos`
#### REST
- GET `localhost:8080/universidade/rest/cursos`: busca todos cursos cadastrados
- POST `localhost:8080/universidade/rest/cursos`: criar novo curso
- GET `localhost:8080/universidade/rest/cursos/{id}`: busca curso especificado
- PUT `localhost:8080/universidade/rest/cursos/{id}`: atualizar curso especificado
- DELETE `localhost:8080/universidade/rest/cursos/{id}`: remover curso especificado
- GET `localhost:8080/universidade/rest/cursos/{id}/disciplinas`: busca todas disciplinas do curso especificado
### Disciplinas
#### SOAP
- `localhost:8080/universidade/disciplinas`
#### REST
- GET `localhost:8080/universidade/rest/disciplinas`: busca todas disciplinas cadastradas
- POST `localhost:8080/universidade/rest/disciplinas`: criar nova disciplina
- GET `localhost:8080/universidade/rest/disciplinas/{id}`: busca disciplina especificada
- PUT `localhost:8080/universidade/rest/disciplinas/{id}`: atualizar disciplina especificada
- DELETE `localhost:8080/universidade/rest/disciplinas/{id}`: remover disciplina especificada
