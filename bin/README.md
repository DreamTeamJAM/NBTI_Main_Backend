# NBTI Backend

Spring Project for managing the database of the company, and handle requests from the websites to acces de database.

## Deployment:

To deploy on AWS, you first need to package the project with the command:

`mvn clean package shade:shade`

And then upload to AWS Lambda with you IAM User

The project can still be tested in local running it as any other Spring App, where it will deploy a local server.
