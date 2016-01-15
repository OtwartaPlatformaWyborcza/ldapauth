# LDAP Auth
REST service which provide authentication against LDAP / ADS.

# LDAP Auth-mock
REST service which provide authentication against mocked LDAP / ADS.

# Links
| Stage | Module  | Link  |
| -------------| ------------- | ------------- |
| - | JIRA | [https://otwartapw.atlassian.net/](https://otwartapw.atlassian.net/secure/RapidBoard.jspa?rapidView=6&projectKey=LDAPAUTH)  |
| DEV | LDAPAuth | http://dev.otwartapw.pl/ldapauth/  |
| DEV | LDAPAuth-Mock | http://dev.otwartapw.pl/ldapauth-mock/  |
| TEST | LDAPAuth | http://test.otwartapw.pl/ldapauth/  |
| TEST | LDAPAuth-Mock | http://test.otwartapw.pl/ldapauth-mock/  |
| PROD | LDAPAuth | http://otwartapw.pl/ldapauth/  |
| PROD | LDAPAuth-Mock | http://otwartapw.pl/ldapauth-mock/  |


# Configuration
All configuration parameters are defined within JNDI context.  

## LDAP Auth
Overview of JNDI configuration parameters

| JNDI | Default  | Description  |
| -------------| ------------- | ------------- |
| java:global/ldapauth/ABC | - |  |

## LDAP Auth Mock
Overview of JNDI configuration parameters

| JNDI | Default  | Description  |
| -------------| ------------- | ------------- |
| java:global/ldapauth-mock/cachesize | 5 | Cache size |
| java:global/ldapauth-mock/secretkey | secret | optional |

Example `standalone.xml` for WildFly 9.0.2.Final
```xml
...
<subsystem xmlns="urn:jboss:domain:naming:2.0">
   <bindings>
      <simple name="java:global/ldapauth-mock/secretkey" value="TopSecret.!" type="java.lang.String"/>
      <simple name="java:global/ldapauth-mock/usercache" value="15" type="int"/>
   </bindings>
   <remote-naming/>
</subsystem>
...
```

# Roadmap

## Version 0.2.0
Service implementation.
* [LDAPAUTH-1]((https://otwartapw.atlassian.net/browse/LDAPAUTH-1) Authentication
* [x] [LDAPAUTH-6]((https://otwartapw.atlassian.net/browse/LDAPAUTH-6) API implementation
* [LDAPAUTH-7]((https://otwartapw.atlassian.net/browse/LDAPAUTH-7) Service configuration with JNDI
* [x] [LDAPAUTH-8]((https://otwartapw.atlassian.net/browse/LDAPAUTH-8) Reusable version output
* [LDAPAUTH-9]((https://otwartapw.atlassian.net/browse/LDAPAUTH-9) Unit Tests (JUnit & Mockito)

## Version 0.3.0
Quality assurance 
* [LDAPAUTH-10]((https://otwartapw.atlassian.net/browse/LDAPAUTH-10) Integration Tests (Arquillian & RESTEasy client)

## Version 0.4.0
Beta release.

## Version 0.5.0
RC1  

## Version 0.6.0
RC2  


## Version 1.0.0
First release


# Changelog

## Version 0.1.0 [released 2015.12.03]
Service definition and MOCK implementation.
* [x] [LDAPAUTH-2](https://otwartapw.atlassian.net/browse/LDAPAUTH-2) Mock implementation
* [x] [LDAPAUTH-3](https://otwartapw.atlassian.net/browse/LDAPAUTH-3) POM cleanup
* [x] [LDAPAUTH-5](https://otwartapw.atlassian.net/browse/LDAPAUTH-5) Userfriendly populate and clear logic for mock.
* [x] [LDAPAUTH-4](https://otwartapw.atlassian.net/browse/LDAPAUTH-4) API definition.
