Feature: Login
  Background:
    * url baseUrl
    * path '/login'
    # Load the JWT service bean from Spring DI
    * def jwtService = appContext.getBean('jwtService')

  Scenario: Login with valid credentials
    Given request { username: 'user', password: 'password' }
    When method post
    Then status 200
    * print response

    # Use the JWT service bean to decode the JWT from the response
    * def decodedJwt = jwtService.decode(response)
    * print decodedJwt
    * def decodedBody = decodedJwt.getBody()
    * print decodedBody

    And match decodedBody['sub'] == 'user'
    * def issuedAt = Number(decodedBody['iat'])
    # Ensure the issuedAt is in the past
    And assert issuedAt < Java.type('java.lang.System').currentTimeMillis()
    * def configuredExpirationInMinutes = Number(environment.getProperty('jwt.expiration.ms')) / 1000
    # Ensure the expiration is the configurable amount of minutes beyond the issuedAt
    And match Number(decodedBody['exp']) == issuedAt + configuredExpirationInMinutes
