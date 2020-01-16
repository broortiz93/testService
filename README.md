# jso-fwk-hello-service
# **Javanes :: Framework :: Hello :: Service**

## Objetivo del Arquetipo.

***jso fwk hello service*** 

Su papel es servir de modelo base para la implementación y/o generación de cualquier servicio simple desplegable en openshift.
   
## Dependencias con otros arquetipos.

### Zuul Service.

### Zuul SSO Service.

## Dependencias de infraestructura.

   
### org.springframework.cloud/ Spring-cloud-starter.

Proporciona herramientas para que los desarrolladores construyan rápidamente algunos de los patrones comunes en sistemas distribuidos. La coordinación de los sistemas distribuidos conduce a los patrones de la placa de la caldera, y el uso de los desarrolladores de *Spring Cloud* puede desplegar rápidamente los servicios y las aplicaciones que implementan esos patrones. Funcionarán bien en cualquier entorno distribuido, incluida la computadora portátil del desarrollador, los centros de datos básicos y las plataformas administradas como Cloud Foundry.

### org.springframework.boot/ Spring-cloud-starter-web.

Iniciador para la creación de aplicaciones web, incluidas las aplicaciones REST, que utilizan Spring MVC. Utiliza Tomcat como el contenedor embebido predeterminado

### io.springfox/ Springfox-swagger2.

Permite crear servicios web RESTful con facilidad, Swagger especifica un formato para describir las capacidades y operaciones de estos servicios y con *Swagger UI* es posible explorar nuestra API REST con una interfaz gráfica de usuario el navegador. Es un proyecto que apunta a crear documentación de API JSON automatizada para las API creadas con Spring y se usa en el siguiente tutorial para integrar Swagger en una aplicación de muestra.

### org.springframework.boot/ Spring-cloud-starter-test.

Proporciona una serie de utilidades y anotaciones para ayudarlo a probar la aplicacion, importa tanto los módulos de prueba de arranque de primavera como JUnit, AssertJ, Hamcrest y varias otras bibliotecas útiles.
 
## Descarga de GIT. 

   ### Proceso.

Si se desea obtener una copia del repositorio Git existente el comando que se necesita  es  ***git clone***. Si utilizas otros sistemas de control de versiones como puede ser Subversion, verás que el comando es *clone* y no ***checkout***.  Git recibe una copia de casi todos los datos que tiene el servidor, y cada versión de cada archivo de la historia del proyecto es descargado cuando se ejecuta ***git clone***. 

```
$ git clone +  "url"
```
Esto crea un directorio llamado ***"jso fwk hello service"***, inicializa un directorio .git en su interior, descarga toda la información de ese repositorio, y saca una copia de trabajo de la última versión. Git te permite usar distintos protocolos de transferencia. El ejemplo anterior usa el protocolo ***git://***, pero también te puedes encontrar con:
***http(s):// o usuario@servidor:/ruta.git***  *(utiliza el protocolo de transferencia SSH).*
    
    
## Compilación. 

-Se crean archivos de origen reales bajo el proyecto HelloService. Se crea un paquete. Clic derecho en src en la sección del explorador de paquetes y siga la opción - Nuevo y  Paquete. Se crean los archivos Helloservice.java y MainApp.java en el paquete creado. Primero se crea un contexto de aplicación donde se usa la API del framework, se carga el archivo de configuración de los beans y, eventualmente, se encarga de crear e inicializan todos los objetos.

-Después se utiliza el método **getBean ()** del contexto creado. Para que finalmente se pueda convertir en el objeto real. Y finalmente se puede usar este objeto para llamar a cualquier método de clase. Se debe crear un archivo de configuración de Bean (XML)  y  une los beans.

-Beans.xml sasigna ID únicas a distintas beans y para controlar la creación de objetos con diferentes valores. Al usar el siguiente archivo, puede pasar cualquier valor para la variable "mensaje" y puede imprimir diferentes valores de mensaje sin afectar los archivos **Helloservice.java y “MainApp.java”**.

-Cuando la aplicación se carga en la memoria, Framework utiliza el archivo de configuración anterior para crear beans definidos y les asigna una ID única como se define en la etiqueta <bean>. Utiliza la etiqueta <property> para pasar los valores de diferentes variables utilizadas en el momento de la creación del objeto.

-Cuando se hayan terminado de crear los archivos de configuración de origen y beans, se procederá a compilar y ejecutar el programa. Manteniendo la pestaña del archivo **“MainApp.Java”** activa, usar cualquiera de las opciones de ejecución disponibles en el IDE de Eclipse. Ésto imprimirá el siguiente mensaje en la consola de Eclipse IDE.

## Despliegue en openshift.
 
-Cambiar fabric8.generator.from en pom.xml

-Cambiar en src/main/fabric8/deployment.yml subir memoria 256M.

**1. Desplegar hello-service.**
```
mvn clean verify fabric8:deploy -Popenshift
```
### Deployment.yaml de hello service. 
``` 
metadata: 
  labels: 
    app: jso-framework 
spec: 
  replicas: 1 
  template: 
    spec: 
      containers: 
        - env: 
            - name: SPRING_PROFILES_ACTIVE 
              value: 'default,dev' 
          name: jso-fwk-hello-service-app 
          ports: 
            - containerPort: 8080 
              name: http 
              protocol: TCP 
            - containerPort: 9779 
              name: prometheus 
              protocol: TCP 
            - containerPort: 8778 
              name: jolokia 
              protocol: TCP 
            - containerPort: 8181 
              name: actuator 
              protocol: TCP 
          livenessProbe: 
            httpGet: 
              path: /actuator/health 

-port: 8181
-scheme: HTTP
-initialDelaySeconds: 30
-periodSeconds: 10
-timeoutSeconds: 5
-readinessProbe:
-failureThreshold: 3
-httpGet: path: /actuator/health
-port: 8181
-scheme: HTTP
-initialDelaySeconds: 40
-periodSeconds: 10
-timeoutSeconds: 5
-resources:
-limits:
-cpu: '1'
-memory: 128M
-requests:
-cpu: 100m
-memory: 32M
```
