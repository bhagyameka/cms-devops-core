
def fromgithub(String branch = 'null') {
					echo "You have chosen branch:"
	                                println "${branch}"
					git branch: "$branch", url: "https://github.com/bhagyameka/calculator-cms.git", credentialsId: 'c6947d68-906d-4126-a88a-d93c8d4a1ec8'
		                        }

  def mavenbuild() {
 
		echo "You have chose to build using maven"
	        sh 'mvn --version'
	        sh 'mvn clean package' 
	        sh 'ls target/'
				
			}
