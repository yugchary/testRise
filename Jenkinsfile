pipeline {
    agent any
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MyMaven"
    }

    stages {
        stage('Clean stage') {
            steps {
                echo 'compiling'
                     

                // To run Maven on a Windows agent, use
                bat "mvn clean"               
                
               
            }
        }
        stage('Testing Stage') {
            steps {
                echo 'testing'
                     

                // To run Maven on a Windows agent, use
                bat "mvn install"
                
                
                
            }
        }
    }
}