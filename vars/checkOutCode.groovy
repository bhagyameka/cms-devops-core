
def fromgithub(String branch = 'null') {
pipeline {
	environment {
			BRANCH_NAME = "${branch}"
		}
		agent {label 'slave2'}
		stages {
			stage('Source Code from SCM') {
				steps {
					echo "You have chosen branch:"
	                                println "${branch}"
					script{
					//checkOutCode.fromgithub("develop")
					 if ( "$branch" == 'develop'){
			                    git branch: "$branch", url: "https://github.com/bhagyameka/calculator-scriptsrepo.git", credentialsId: 'c6947d68-906d-4126-a88a-d93c8d4a1ec8'
		                           }
		                        else 
			                  {
		                           echo " $branch branch is not allowed for building "
		                           sh 'exit 1'
			                  }	
				}
			}
			}			  
		}
	    }
}
    
  
  
