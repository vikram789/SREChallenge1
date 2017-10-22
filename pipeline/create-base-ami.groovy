node('ansible') {
    stage('checkout code') {
        git url: 'https://github.com/vikram789/SREChallenge1.git'
    }
    stage('Create-Base-AMI') {
        try{
            sh ". /home/ec2-user/.bash_profile; ansible-playbook -v ansible/base_ami_setup.yml"
        }
        catch (exc){
            echo "Something failed..!!"
            currentBuild.result = 'FAILURE'
        } 
    }
}
