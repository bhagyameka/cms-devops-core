import checkOutCode
	pipeline {
		agent {label 'slave2'}
		stages {
			stage('Source Code from SCM') {
				steps {
					codeCheckOut.call("$BRANCH_NAME")
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
