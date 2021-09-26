pipeline {
    agent any
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MyMaven"
    }

    stages {
        stage('Compile Stage') {
            steps {
                echo 'compiling'
                     

                // To run Maven on a Windows agent, use
                bat "mvn clean compile"               
                
               
            }
        }
        stage('Testing Stage') {
            steps {
                echo 'testing'
                     

                // To run Maven on a Windows agent, use
                bat "mvn test -Dsurefire.suiteXmlFiles=C:\\Users\\yugandher.akkunuru\\eclipse-workspace\\testRise\\risetestng_DryRun.xml"
                
                
                
            }
        }
    }
}