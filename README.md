# app_discovery_server

## Description
Find app for specific task

## Development
### Within Intellij Using Embedded DB
- Requires Intellij >=14.1.4
- Open project in Intellij
- Create a 'Spring Boot' run configuration with following settings:
    - Main class: `com.zhou.appdiscovery.AppDiscoveryApplication`
    - Use classpath of module: app_discovery_server
    - Active Profiles: local
- Hit run/debug button

### Using Vagrant Env with Real SQL DB
- Open project in Intellij
- Run gradle build task to generate app jar
- Deploy app jar to vagrant env using `app_discovery_deploy`; refer to README in that repo
- Create a 'Remote' run configuration with following settings:
    - Host: app-discovery-api
- Hit debug button to attach to the remote debug port
