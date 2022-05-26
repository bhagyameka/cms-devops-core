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
					sh 'pwd'
					script{
						try{
					echo " You are on stage Source Code from SCM "	
						if ("$BN" == 'master' || "$BN" == 'sit' || "$BN" == 'uat' ){
					        echo " Build on $BN branch is not allowed"
					        sh 'exit 1'
						}
						else{
							echo "checkoutcode"
							checkOutCode.fromgithub("$BN")
							//sh 'ls'
							//sh ' ls target/'
							//sh 'cp /home/slave2/remoting.jar src/'
							//sh 'ls src/'
							sh 'mkdir new'
							sh 'ls '
							sh 'cd new'
							sh 'mkdir new1'
							sh 'ls'
							
						}
				}
						
    catch (Exception e) {
	    currentBuild.result = "FAILURE"
      echo 'Exception occurred: ' + e.toString()
      sh 'Handle the exception!'
	     echo e.getMessage()
  }
  
					}
					 
					
			}
			}
		        stage('build using maven') {
				steps {
					
					echo "building using maven"
					//sh 'mvn --version'
					//sh 'mvn clean package'
					//script{
			                //checkOutCode.mavenbuild()
					//}
					}	
			}
			stage('unit testing') {
                               steps {
       			       echo '*******unit testing starts*******'
                              // junit skipPublishingChecks: true, testResults: '**/target/surefire-reports/TEST-*.xml'   
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
