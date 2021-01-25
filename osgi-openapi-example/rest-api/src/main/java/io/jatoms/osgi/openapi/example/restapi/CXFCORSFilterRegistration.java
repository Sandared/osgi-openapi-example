package io.jatoms.osgi.openapi.example.restapi;

import java.util.Hashtable;

import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;
import org.osgi.annotation.bundle.Capability;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
@Capability(namespace = "osgi.service", attribute = {"objectClass:List<String>=javax.ws.rs.container.ContainerResponseFilter", "objectClass:List<String>=javax.ws.rs.container.ContainerRequestFilter"})
public class CXFCORSFilterRegistration {
    private final Logger log = LoggerFactory.getLogger(CXFCORSFilterRegistration.class);

    private ServiceRegistration<ContainerResponseFilter> registrationRes;
    private ServiceRegistration<ContainerRequestFilter> registrationReq;

    @Activate
    void acitvate(BundleContext context){
        try {
            Hashtable<String, Object> props = new Hashtable<>();
            props.put(JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT, "(osgi.jaxrs.name=apiv1)");
            props.put(JaxrsWhiteboardConstants.JAX_RS_EXTENSION, true);
            CrossOriginResourceSharingFilter filter = new CrossOriginResourceSharingFilter();
            registrationRes = context.registerService(ContainerResponseFilter.class, filter, props);
            registrationReq = context.registerService(ContainerRequestFilter.class, filter, props);
        } catch (Exception e) {
            log.error("Could not activate CXF CORS filter!", e);
            throw e;
        }
    }

    @Deactivate
    void deactivate() {
        try {
            registrationRes.unregister();
            registrationReq.unregister();
        } catch (Exception e) {
            log.warn("Could not unregister OpenAPI registration!", e);
            throw e;
        }
    }
}