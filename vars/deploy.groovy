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
	if ("$DEPLOY_TO" == 'master') {
  
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		
 else if ("$DEPLOY_TO" == 'develop') {
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		
else if ("$DEPLOY_TO" == 'integrate') {
          echo "*******deploy on weblogic Start to $DEPLOY_TO *******"
          echo '*******deploy on weblogic done*******'
          }
		
 else {
          echo "No such branch found--$DEPLOY_TO"
                   }
		}
}
}
	
}
}
}
