
def call(String branch = 'null') {

					echo "You have chosen branch:"
	                                println "${branch}"
					script{
					
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

  
