pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
                echo 'Hello World'
                withMaven(maven: 'MyMaven'){
                    sh 'mvn clean compile'
                }
            }
        }
    }
}