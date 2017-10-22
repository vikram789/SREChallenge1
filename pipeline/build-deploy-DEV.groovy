node('ansible') {
    stage('checkout code') {
        git url: 'https://github.com/vikram789/SREChallenge1.git'
    }
    stage('Build and Compile') {
        perl -pe 's/BUILD/${env.BUILD_NUMBER}/g' src/index.html
    }
    stage('Sonar Validation') {
        echo "Sonar code goes here"
    }
    stage('Build-Deploy-Dev') {
    /*     try{
            sh ". /home/ec2-user/.bash_profile; ansible-playbook -v ansible/create_dev_env.yml"
        }
        catch (exc){
            echo "Something failed..!!"
            currentBuild.result = 'FAILURE'
        }  */
    }
    stage("Validation") {

    }
    stage("Update-Component-AMI") {
  
    }
}
