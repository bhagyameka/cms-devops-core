 static def fromgithub (String branch = 'null') {
	
		environment {
			BRANCH_NAME = "${branch}"
		}
		echo "You have chosen branch:"
	        println "${BRANCH_NAME}"
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
	
    
  
  
