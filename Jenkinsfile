/* groovylint-disable CompileStatic */
pipeline {
    agent any
    stages {
        stage('code clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('unit test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('deploy to tomcat') {
            steps {
                sh 'mvn package'
                sshagent(credentials: [''], ignoreMissing: true) {
                // some block
                }
            }
        }
    }
}
