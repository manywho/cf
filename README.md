Cloud Foundry Service
=====================

> This service is currently in development

[![Build Status](https://travis-ci.org/manywho/service-cf.svg)](https://travis-ci.org/manywho/service-cf)

This service offers a very basic CF integration for your flows, giving support for authorisation and deploy from source

## Usage

If you need to, it's easy to spin up your own instance of the service if you follow these instructions:

### Configuring

The available configuration settings for the application are:

* **REDIS_URL:** A Redis connection string, e.g. `redis://localhost:5432`

#### Environment Variables

You will have to configure the application at runtime by using environment variables, so you will need to run the
application like this:

```bash
$ REDIS_URL=redis://localhost:5432 java -jar target/cf-*.jar
```

### Building

To build the application, you will need to have Maven 3 and a Java 8 implementation installed (OpenJDK and Oracle Java SE
are both supported).

Now you can build the runnable shaded JAR:

```bash
$ mvn clean package
```

### Running

The application is a RestEASY JAX-RS application, that by default is run under the Jetty server on port 8080 (if you
use the packaged JAR).

#### Defaults

Running the following command will start the service listening on `0.0.0.0:8080`:

```bash
$ java -jar target/cf-*.jar
```

## Contributing

Contributions are welcome to the project - whether they are feature requests, improvements or bug fixes! Refer to 
[CONTRIBUTING.md](CONTRIBUTING.md) for our contribution requirements.

## License

This service is released under the [MIT License](https://opensource.org/licenses/MIT).
