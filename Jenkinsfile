pipeline {
    agent any
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MyMaven"
    }

    stages {
        stage('Compile Stage') {
            steps {
                echo 'Hello World'
                // Get some code from a GitHub repository
                git 'https://github.com/yugchary/testRise.git'

          

                // To run Maven on a Windows agent, use
                bat "mvn clean"
            }
        }
    }
}