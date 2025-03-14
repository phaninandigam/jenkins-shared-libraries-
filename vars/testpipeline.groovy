def testcheckout1() {
    echo 'Checking out code...'
    checkout scm
}

def testbuild1() {
    echo 'Building project with Maven...'
    sh 'mvn clean package'
}

def testrun1() {
    echo 'Running Spring Boot application...'
    sh 'nohup mvn spring-boot:run &'

    def publicIp = sh(script: "curl -s https://checkip.amazonaws.com", returnStdout: true).trim()
    echo "The application is running and accessible at: http://${publicIp}:8080"
    sleep(time: 60, unit: 'SECONDS')

   
}
