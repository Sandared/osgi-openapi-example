package io.jatoms.osgi.openapi.example.restapi;

public class Doc {

    public static class Api{
        public static class Tags{
            public static final String item = "item";
        }
        
        public static class Info {
            public static final String title = "qbilon REST API";
            public static final String description = ""  
            + "# Introduction\n"
            + "This API is documented in **OpenAPI format**\n"
            + "This frontend is created with [Redocly](https://github.com/Redocly/redoc)"
            + "In addition to standard OpenAPI syntax we use a few [vendor extensions](https://github.com/Redocly/redoc/blob/master/docs/redoc-vendor-extensions.md).\n"
            + "# OpenAPI Specification\n"
            + "The OpenAPI Specification provides [annotations](https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#extension) that are used in this project to generate the sepcification json/yaml.\n"
            + "More information about OpenAPI specification can be found [here](https://swagger.io/specification/)\n"
            + "" ; 
        }
    }
}
