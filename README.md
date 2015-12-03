# LDAP Authentication
REST service for authentication against LDAP / ADS


# Links
| Stage | Module  | Link  |
| -------------| ------------- | ------------- |
| - | JIRA | https://otwartapw.atlassian.net/  |
| DEV | LDAPAuth | http://dev.otwartapw.pl/ldapauth/  |
| DEV | LDAPAuth-Mock | http://dev.otwartapw.pl/ldapauth-mock/  |
| TEST | LDAPAuth | http://test.otwartapw.pl/ldapauth/  |
| TEST | LDAPAuth-Mock | http://test.otwartapw.pl/ldapauth-mock/  |
| PROD | LDAPAuth | http://otwartapw.pl/ldapauth/  |
| PROD | LDAPAuth-Mock | http://otwartapw.pl/ldapauth-mock/  |


# Configuration

## LDAP Auth

## LDAP Auth Mock
Application is configured via JNDI.

| JNDI | Default  | Description  |
| -------------| ------------- | ------------- |
| java:global/ldapauth-mock/cachesize | 5 | Cache size |
| java:global/ldapauth-mock/secretkey | secret | optional |

# Roadmap

## Version 0.2.0
Service implementation.
* [LDAPAUTH-6]((https://otwartapw.atlassian.net/browse/LDAPAUTH-6) Service implementation
* [LDAPAUTH-7]((https://otwartapw.atlassian.net/browse/LDAPAUTH-7) Service configuration with JNDI

## Version 0.3.0
Beta release.

## Version 0.4.0
RC1  

## Version 0.5.0
RC2  


## Version 1.0.0
First release


# Changelog

## Version 0.1.0 [released 2015.12.03]
Service definition and MOCK implementation.
* [x] [LDAPAUTH-2]((https://otwartapw.atlassian.net/browse/LDAPAUTH-2) Mock implementation
* [x] [LDAPAUTH-3]((https://otwartapw.atlassian.net/browse/LDAPAUTH-3) POM cleanup
* [x] [LDAPAUTH-5]((https://otwartapw.atlassian.net/browse/LDAPAUTH-5) Userfriendly populate and clear logic for mock.
* [x] [LDAPAUTH-4]((https://otwartapw.atlassian.net/browse/LDAPAUTH-4) API definition.

