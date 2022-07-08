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
							sh 'ls'
							//sh ' ls target/'
							//sh 'cp /home/slave2/remoting.jar src/'
							//sh 'ls src/'
							//sh 'zip -r cms-application-ext.zip application.properties log4j2.properties'
							//sh 'mv cms-application-ext.zip cms-application-ext.1.`date +"%y%m%d"`.${BUILD_NUMBER}.zip'
							//sh 'ls'
							sh 'echo "Hello how are you doing" > cert.pem'
							sh 'mkdir -p certificate/ssl'
							sh 'mv cert.pem certificate/ssl/'
							sh 'ls certificate/ssl/'
							
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
					sh 'mvn --version'
					//sh 'mvn clean package'
					script{
					
						//sh 'mvn --batch-mode release:update-versions -DdevelopmentVersion=2.0-SNAPSHOT'
					        sh 'mvn clean package'
						sh 'ls target/'
						sh 'jarname= find target -name *.jar'
						echo "${jarname}"
					
					}
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
