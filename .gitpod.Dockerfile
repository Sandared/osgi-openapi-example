FROM gitpod/workspace-full

USER gitpod
# Set path to include Karaf that will be downloaded during the init task
ENV PATH="/workspace/apache-karaf-4.3.0/bin/:$PATH"
ENV JAVA_TOOL_OPTIONS="-Xmx4096m"

# return control
USER root
