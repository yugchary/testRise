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
                     

                // To run Maven on a Windows agent, use
                bat "mvn clean"
            }
        }
    }
}