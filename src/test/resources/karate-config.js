/**
 * Define common feature file configuration here.
 * @returns Common configuration as a JSON object.
 */
function getConfig() {
    // Global values
    const appContext = Java.type("org.tpero.ApplicationContextHolder")
        .getApplicationContext()
    const environment = appContext.getEnvironment()

    return {
        appContext: appContext,
        environment: environment,

        baseUrl: `http://localhost:${environment.getProperty('app.server.port', '8080')}`
    }
}
