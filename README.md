# Grafana
> ### How to connect
> - URL: http://localhost:3000/
> - Username: admin
> - Password: admin

> ### Add first data source
> ##### Postgres
> - Type: Postgres
> - Host: http://host.docker.internal:5432
> - Database: postgres
> - Username: postgres
> - Password: postgres

#


# Prometheus
> ### How to connect
> - URL: http://localhost:9090/

#

# SonarQube
> ### How to connect
> - URL: http://localhost:9000/
> - Username: admin
> - Password: admin

> ### Create project
> - `Create a local project`
>  - Project display name: `demo.springboot`
>  - Project key: `demo.springboot`
>  - Main branch name: `main` / `master` / `development`
>  - `Next`
> - `Use global settings`
> - `Create project`

> ### Analysis method
> - `Locally`
>  - Expires in: `No expiration`
>  - Generate
>  - Continue
> - `Maven`
>  - Copy the command generated
>  - Paste inside your terminal
>    - If the code doesn't works, run with ``./mvnw`` at the start
> - Refresh the browser and your analysis will be there asap
> - For example
> - ./mvnw clean verify sonar:sonar -Dsonar.projectKey=demo.springboot -Dsonar.projectName='demo.springboot' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_ff33420edf5443ca1b7afe45da67996e1ebf0550
#

# RabbitMQ
> ### How to connect
> - URL: http://localhost:15672/
> - Username: guest
> - Password: guest

#

# Actuator/HealthCheck
> ### Endpoint
> - Path: `/actuator/health`
> - cURL: ``curl --location 'http://localhost:8080/actuator/health'``
 