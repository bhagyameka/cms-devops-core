def call(String branch = 'null') {
	pipeline {
     environment {
			DEPLOY_TO = "${branch}"
		}
agent {label 'slave2'}

stages {
 stage ('Download from Jfrog') {
      steps {
	      script{
          if ("$DEPLOY_TO" == 'master' || "$DEPLOY_TO" == 'sit' || "$DEPLOY_TO" == 'uat' ){
					        echo " Deploy on $DEPLOY_TO branch is not allowed"
					        sh 'exit 1'
						}
						else{
							echo '*******download from JFrog*******' 							
						}
         
	      }
      }
 }
        
 stage ('Deploy on Weblogic') {
	 steps {
		 echo "*******deploy on weblogic Start to $DEPLOY_TO ENV *******"
	   sh 'pwd'
	   echo '*******deploy on weblogic done*******'
        }
}


	
}
}
}
