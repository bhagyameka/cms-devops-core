import groovy.transform.Field
@Field def timeStamp = Calendar.getInstance().getTime().format('YYYYMMdd-hhmmss',TimeZone.getTimeZone('CST'))
def call(String branch = 'null') {
	echo "This is shared library deploy: ${branch}"
	if ("${branch}" == 'develop') {
pipeline {
     environment {
			DEPLOY_TO = "${branch}"
		}
agent {label 'slave2'}

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
	//if ("$DEPLOY_TO" == 'develop') {
  
          echo "*******deploy on weblogic Start to $DEPLOY_TO ENV *******"
	  sh 'pwd'
	  //sh 'mv *.txt hello`date +"%d-%m-%Y-%H:%M"`.txt'
	  echo "${timeStamp}"
	  //sh 'mv *.txt hello_${timeStamp}.txt'
	  echo '*******deploy on weblogic done*******'
        //  }
		
 //else  {
 //         echo "*******deployment to $DEPLOY_TO ENV is not allowed*******"
//	  sh 'exit 1'
//                    }
		
		}
}
}
	
}
}
}
	else {
		echo "Deployment is not allowed"
	}
}
