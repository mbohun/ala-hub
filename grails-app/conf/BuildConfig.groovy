grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}.war"
//grails.plugin.location.'biocache-hubs' = "../biocache-hubs"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo ("http://maven.ala.org.au/repository") {
            updatePolicy 'always'
        }
        mavenRepo "http://maven.tmatesoft.com/content/repositories/releases/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime 'mysql:mysql-connector-java:5.1.27'
        // runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'
    }

    plugins {
        build ":tomcat:7.0.54"
        compile ':cache:1.1.1'
        compile ":cache-headers:1.1.6"
        runtime ":resources:1.2.8"
        runtime ":cached-resources:1.0"
        runtime ":biocache-hubs:0.55"
        runtime ":ala-web-theme:0.8.1"
    }
}

grails.project.repos.'nectar-nexus-repo-snapshot'.url = "http://130.56.249.242/nexus/content/repositories/snapshots/"
grails.project.repos.'nectar-nexus-repo-snapshot'.username = System.getenv("TRAVIS_DEPLOY_USERNAME")
grails.project.repos.'nectar-nexus-repo-snapshot'.password = System.getenv("TRAVIS_DEPLOY_PASSWORD")

grails.project.repos.'nectar-nexus-repo-release'.url = "http://130.56.249.242/nexus/content/repositories/releases/"
grails.project.repos.'nectar-nexus-repo-release'.username = System.getenv("TRAVIS_DEPLOY_USERNAME")
grails.project.repos.'nectar-nexus-repo-release'.password = System.getenv("TRAVIS_DEPLOY_PASSWORD")
