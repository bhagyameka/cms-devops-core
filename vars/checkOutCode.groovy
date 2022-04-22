static def call(String branch = 'null') {
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
						if ( "$BRANCH_NAME" == 'develop'){
					git branch: "$BRANCH_NAME", url: "https://github.com/bhagyameka/calculator-scriptsrepo.git", credentialsId: 'c6947d68-906d-4126-a88a-d93c8d4a1ec8'
				          }
						else 
						{
					         echo " $BRANCH_NAME branch is not allowed for building "
						 sh 'exit 1'
						}
					}
				}
			}
    }
  }
  
