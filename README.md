# osgi-openapi-example
A repository showcasing the usage of openapi annotations in an OSGi REST API for documentation purposes. Leveraging the beatiful Redocly visualization as frontend

This repository is [![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/Sandared/osgi-openapi-example)
After Gitpod has started, just type these two commands into the "Backend" (Karaf) console:
* `feature:repo-add mvn:io.jatoms/featurerepo/1.0-SNAPSHOT/xml`
* `feature:install jatoms-openapi` 

Then open another console and type `gp url 8181` and open the address that is printed.

## Project layout

This project is a maven multi-module project that consists of three submodules
* featurerepo: this contains the karaf feature descriptor which contains all dependencies needed to run this example in a Karaf container
* openapi-integration: this contains a pom.xml and a local copy of the apache aries jax-rs whiteboard openapi integration, as it is not published on maven central yet. This subproject takes care of installing it in your local repository
* openapi-example: This submodule consists again of two submodules:
  * model: the model code used in the REST API which is annotated with Swagger annotations for the openapi parser
  * rest-api: the actual JAX-RS REST API also containing annotations for the openapi parser and some additional classes:
    * `APIV1`: A Jax-RS Application under which our ressources are registered
    * `OpenAPIIntegration`: a simple service that registers an `OpenAPI` service which is then picked up by the openapi integration
    * `OpenAPIFrontend`: a simple static resource that serves the Redocly frontend 
    * `ItemEndpoint`: the actual endpoint (No implementation contained, just TODOs :) )
    * `Doc`: some static Strings used in the documentation