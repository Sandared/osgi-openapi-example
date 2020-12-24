package io.jatoms.osgi.openapi.example.restapi;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource;

@Component(service = OpenAPIFrontend.class)
@HttpWhiteboardResource(pattern = "/doc/*", prefix = "/index.html")
public class OpenAPIFrontend {}
