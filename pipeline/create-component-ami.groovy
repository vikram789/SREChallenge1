node('ansible') {
    stage('checkout code') {
        git url: 'https://github.com/vikram789/SREChallenge1.git'
    }
    stage('Build and Compile') {
        sh "sed -i 's/BUILD/${env.BUILD_NUMBER}/' src/index.html"
        echo env.BUILD_NUMBER
    }
    stage('Sonar Validation') {
        echo "Sonar code goes here"
    }
    stage('Build-Deploy-CI-Env') {
         try{
            sh ". /home/ec2-user/.bash_profile; ansible-playbook -v ansible/component_ami_setup.yml"
        }
        catch (exc){
            echo "Something failed..!!"
            currentBuild.result = 'FAILURE'
        }  
    }
}

