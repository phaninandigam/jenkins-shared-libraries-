def testcheckout() {
    echo 'Checking out code...'
    checkout scm
}

def testbuild() {
    echo 'Building project with Maven...'
    sh 'mvn clean package'
}

def testrun() {
    echo 'Running Spring Boot application...'
    sh 'nohup mvn spring-boot:run &'

    def publicIp = sh(script: "curl -s https://checkip.amazonaws.com", returnStdout: true).trim()
    echo "The application is running and accessible at: http://${publicIp}:8080"
    sleep(time: 60, unit: 'SECONDS')

   
}
