# spring-boot-training
Spring Boot Training Samples

## Prerequisites

### Set up Java8 JDK
* Set up Java developer kit (JDK) not Java runtime environment (JRE)
* Set JAVA_HOME and PATH environment variables.
* See [Oracle JDK 8 installation overview](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

### Set up GIT client
* See [Github.com documentation](https://help.github.com/articles/set-up-git/)
* Set up proxy server (if required)
Command to use :
```bash
git config --global http.proxy http://proxyuser:proxypwd@proxy.server.com:8080
git config --global https.proxy https://proxyuser:proxypwd@proxy.server.com:8080
```
* change proxyuser to your proxy user
* change proxypwd to your proxy password
* change proxy.server.com to the URL of your proxy server
* change 8080 to the proxy port configured on your proxy server

* If you decide at any time to reset this proxy and work without (no proxy):
Commands to use:
```bash
git config --global --unset http.proxy
git config --global --unset https.proxy
```

* Finally, to check the currently set proxy;
```bash
git config --global --get http.proxy
git config --global --get https.proxy
```

### Set up Apache Maven
* See [Apache Maven documentation](https://maven.apache.org/install.html)
* Set M2_HOME, M2 and PATH variables.
* Set up proxy server (if required) 
Put into your ${user.home}/.m2/settings.xml the correct configuration
```xml
<settings>
  <proxies>
   <proxy>
      <id>example-proxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.example.com</host>
      <port>8080</port>
      <username>proxyuser</username>
      <password>somepassword</password>
      <nonProxyHosts>www.google.com|*.example.com</nonProxyHosts>
    </proxy>
  </proxies>
</settings>
```
* change proxyuser to your proxy user
* change somepassword to your proxy password
* change proxy.example.com to the URL of your proxy server
* change 8080 to the proxy port configured on your proxy server

### Set up Docker-Machine
* See [Docker Machine documentation](https://docs.docker.com/machine/install-machine/)
* Set up proxy server (if required) 

### Set up Docker-Compose
* See [Docker Compose documentation](https://docs.docker.com/compose/install/) 
* Run docker-compose.yml with docker-compose up
```bash
docker-compose up
```

### Set up your favorite IDE
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [NetBeans IDE](https://netbeans.org/)
* [Eclipse IDE for Java EE Developers](https://eclipse.org/)
* [Spring Eclipse IDE](https://spring.io/tools/eclipse)
* Set up proxy server in your IDE (if required)

## Check out the code
* If you use {user.home}/workspace/ as your workspace directory this GIT repository will be cloned to {user.home}/workspace/spring-boot-training 
* Ether use your IDE
* Or clone the repository 
```bash
git clone https://github.com/Thinkenterprise/spring-boot-training.git
```

## Useful links: 
* [How to set up environment variables in Linux, Unix, Mac and Windows environments](http://www.tutorialspoint.com/maven/maven_environment_setup.htm)
* [How to set up a Maven HTTP / HTTPS proxy](https://maven.apache.org/guides/mini/guide-proxies.html) 