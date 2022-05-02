def call(String br = 'null'){
pipeline {
	environment {
			BN = "${br}"
		}
		agent {label 'slave2'}
		stages {
			stage('Source Code from SCM') {
				steps {
					echo "You have chosen branch:"
	                                println "$BN"
					script{
					echo " You are on stage Source Code from SCM "	
						if ("$BN" == 'develop'){
					checkOutCode.github("$BN")
						}
						else{
							echo " Build on $BN branch is not allowed"
							sh 'exit 1'
						}
				}
			}
			}
		        stage('build using maven') {
				steps {
					
					echo "building using maven"
					//sh 'mvn --version'
					//sh 'mvn clean package'
					script{
			                checkOutCode.mavenbuild()
					}
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
