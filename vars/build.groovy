def call(String branch = 'null') {
	echo "This is shared library build: ${branch}"
	pipeline {
		environment {
			BRANCH_NAME = "${branch}"
		}
		agent {label 'slave2'}
		stages {
			stage('Source Code from SCM') {
				steps {
					echo "You have chosen branch $BRANCH_NAME"
					println "$BRANCH_NAME"
					script{
						if ("$BRANCH_NAME" == 'master' && "$BRANCH_NAME" == 'develop' && "$BRANCH_NAME" == 'develop'){
					git branch: "$BRANCH_NAME", url: "https://github.com/bhagyameka/calculator-scriptsrepo.git", credentialsId: 'c6947d68-906d-4126-a88a-d93c8d4a1ec8'
				          }
						else 
						{
					         echo " No such branch : $BRANCH_NAME "
						}
					}
				}
			}
		        stage('build using maven') {
				steps {
					echo "building using maven"
					sh 'mvn --version'
					sh 'mvn clean package'
				}	
			}
			stage('unit testing') {
    steps {
        echo '*******unit testing starts*******'
        junit skipPublishingChecks: true, testResults: '**/target/surefire-reports/TEST-*.xml'   
        echo '*******unit testing ends*******'
               
    }
}

stage ('Test using CheckMarX') {
   
    steps {
        echo '*******CheckMarX start*******'
        
   
        echo '*******CheckMarX end*******'
    }
   
}


stage ('Upload to Jfrog') {
     steps {
         echo '*******upload to JFrog start*******'
      
         echo '*******upload to JFrog End*******'
     }
}
		}
		
	}
}
