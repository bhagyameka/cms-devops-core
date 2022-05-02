def SourcecodeCheckout(String br = 'null'){
  echo "You have chosen branch:"
  println "$br"
  checkOutCode.github("$br")
}
def maven(){
  echo "building using maven"
  checkOutCode.mavenbuild()
}
def unitTesting(){
	  echo '*******unit testing starts*******'
          junit skipPublishingChecks: true, testResults: '**/target/surefire-reports/TEST-*.xml'   
           echo '*******unit testing ends*******'
           }
                           

