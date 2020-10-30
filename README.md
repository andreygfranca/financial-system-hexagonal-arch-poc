### Financial System - Microservices and Hexagonal Architecture
This is just a POC for hexagonal architecture with monorepo microservices communicating with rabbitmq.

#### Microservices

- Accounts Payable;
- Accounts Receivable;
- Cash Flow.

#### Running
Firstly, it is needed to build the microservices images in theirs respective modules. For example:

```bash
cd accounts-payable && mvn clean install;
cd docker && make build:latest

```
After build all microservices you have can run it, all together.
```bash
cd docker;
docker-compose -f docker-compose.yml up
```