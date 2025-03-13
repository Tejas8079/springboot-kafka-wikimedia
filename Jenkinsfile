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
    }
        
}