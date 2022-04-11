def call(String branch = 'null') {
	echo "This is shared library deploy: ${branch}"
pipeline {
     environment {
			DEPLOY_TO = "${branch}"
		}
agent any

stages {


 stage ('Download from Jfrog') {
      steps {
          echo '*******download from JFrog start*******'
       
          echo '*******download from JFrog End*******'
      }
 }


        
 stage ('Deploy on Weblogic') {
	 steps {
		 script{
	if ("$DEPLOY_TO" == 'dev') {
  
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		
 else if ("$DEPLOY_TO" == 'sit') {
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		
else if ("$DEPLOY_TO" == 'uat') {
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		
 else {
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		}
}
}
	
}
}
}
