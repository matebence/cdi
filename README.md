> #### Annotations

- @Inject - Creates injection point for CDI bean
- @Produces - Makes possible to inject any type of object
- @Named - Used to differentiate between multiple implementations
- @Qualifer - Creating custom qualifiers to differentiate between multiple implementations
- @Alternative - Creating alternative implementation for exmaple for testing
- @Vetoed - Classes what we want exclude from CDI

- @Disposes - In CDI, since a Producer method generates an object that can then be injected in an application, the Disposer method is used so that the object is removed when its work is completed.
- @Stereotype - A stereotype is a kind of annotation, applied to a bean, that incorporates other annotations. Stereotypes can be particularly useful in large applications in which you have a number of beans that perform similar functions.

- @RequestScoped - Beans are there as long as the HTTP request-response lives. This usually gets created when an HTTP is requested. It gets destroyed when the HTTP request is over. Maps to HTTP request
- @SessionScoped - Beans are there as long as HTTP session lives. This gets created with the first HTTP request. This bean is destroyed when the HTTP session is invalidated. Maps to HTTP session.
- @ConversionScoped - s a bean whose scope describes a user’s interaction with a JavaServer Faces application, within explicit developer-controlled boundaries that extend the scope across multiple invocations of the JavaServer Faces lifecycle. All long-running conversations are scoped to a particular HTTP servlet session and may not cross session boundaries. Maps to JSF lifecycle.
- @ApplicationSoped - Shared across the entire application. Maps to a Web application
- @Dependent - Any instance of the bean injected into an object that is being created by the container is bound to the lifecycle of the newly created object. No injected instance of the bean is ever shared between multiple injection points. Multiple instances can exist at the same time. Maps to clients scope
@ViewScoped - As long as the user is interacting with a similar JSF view, the beans are alive. It is usually created on an HTTP request. The bean gets destroyed when the user post-backs to a different view.
- @FlowScoped - Faces Flow has been inspired by the popular Spring Flow framework and as such it is not intended to be a replacement for the Web application navigation system; rather Faces Flow can be used to encapsulate a set of steps guiding the user through the execution of a business tasks.	

- @Interceptor - Interceptors are used to implement cross-cutting concerns, such as logging, auditing, and security, from the business logic. Its part of AOP.
- @AroundInvoke - Defines an interceptor method that interposes on business methods.
- @Decorator - Decorators are outwardly similar to interceptors. However, they actually perform tasks complementary to those performed by interceptors. Interceptors perform cross-cutting tasks associated with method invocation and with the lifecycles of beans, but cannot perform any business logic. Decorators, on the other hand, do perform business logic by intercepting business methods of beans. This means that instead of being reusable for different kinds of applications as are interceptors, their logic is specific to a particular application.
- @Observes - Fire event and listen for events. Used to implement the Oberser OOP pattern via Java EE.

- @DenyAll - Specifies that no security roles are permitted to access your resources
- @PermitAll - Specifies that all security roles are permitted to access your resources
- @RolesAllowed - specifies the security roles that are permitted to access your resources

- @PostConstruct - CDI calls the methods annotated with @PostConstruct only once, just after the initialization of bean properties.
- @PreDestroy - A method annotated with @PreDestroy runs only once, just before CDI removes our bean from the application context.

- @Remote - When your EJB and its clients will be in a distributed environment - meaning EJBs and clients will reside on separate Java virtual machines. Example : EJBs hosted on a WebSphere Application Server and Servlets that consume EJB APIs hosted on a Tomcat server.
- @Local - Only when it is guaranteed that other enterprise beans or clients will only address the bean within a single JVM. Example, EJBs as well as the Servlets deployed on the same WebSphere server.
- @LocalBean - Is almost same as local client view, but there are differences. Your bean class is not required to implement client view interfaces in this case. All public methods of the bean class are automatically exposed to the caller.

> #### Wildfly setup

```bash
# Download Wildfly
wget https://download.jboss.org/wildfly/24.0.1.Final/wildfly-24.0.1.Final.zip

# Switch to Wildfly directory
cd WILDFLY_HOME

# Start server in standalone mode
standalone.bat

# Connect to management cli
jboss-cli.bat --connect

# Add a Simple Role Decoder which maps the application Roles from the attribute Roles in the File system.
/subsystem=elytron/simple-role-decoder=from-roles-attribute:add(attribute=Roles)

# Let’s define a new filesystem-realm named fsRealm and its respective path on the file system:
/subsystem=elytron/filesystem-realm=CDIRealm:add(path=demofs-realm-users,relative-to=jboss.server.config.dir)

# Next, we add some identities to the Realm:
/subsystem=elytron/filesystem-realm=CDIRealm:add-identity(identity=bence)
/subsystem=elytron/filesystem-realm=CDIRealm:set-password(identity=bence,clear={password="password123"})
/subsystem=elytron/filesystem-realm=CDIRealm:add-identity-attribute(identity=bence,name=Roles, value=["user"])

/subsystem=elytron/filesystem-realm=CDIRealm:add-identity(identity=ecneb)
/subsystem=elytron/filesystem-realm=CDIRealm:set-password(identity=ecneb,clear={password="password123"})
/subsystem=elytron/filesystem-realm=CDIRealm:add-identity-attribute(identity=ecneb,name=Roles, value=["admin","user"])

# Create a new Security Domain which maps our Realm:
/subsystem=elytron/security-domain=CDIDomain:add(realms=[{realm=CDIRealm,role-decoder=from-roles-attribute}],default-realm=CDIRealm,permission-mapper=default-permission-mapper)

# We need an Http Authentication Factory which references our Security Domain:
/subsystem=elytron/http-authentication-factory=example-fs-http-auth:add(http-server-mechanism-factory=global,security-domain=CDIDomain,mechanism-configurations=[{mechanism-name=BASIC,mechanism-realm-configurations=[{realm-name=RealmUsersRoles}]}])

# Finally, a Security Domain in the undertow’s subsystem will be associated with our Http Authentication Factory:
/subsystem=undertow/application-security-domain=AppSecurityDomain:add(http-authentication-factory=example-fs-http-auth)
/subsystem=ejb3/application-security-domain=AppSecurityDomain:add(security-domain=CDIDomain)

# Restart running server
reload
```