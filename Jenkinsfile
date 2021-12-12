pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven_3_6_3'
    }
    environment {
        //once you sign up for Docker hub, use that user_id here
        registry = "qubedprince/yuppie-chef-developerprince-image"
        //- update your credentials ID after creating credentials for connecting to Docker Hub
        registryCredential = '	dockerHub'
    }
    stages {
        stage ('Version'){
            steps {
                sh 'mvn --version'
            }
        }
        stage ('Dependency'){
            steps {
                sh 'mvn dependency:tree'
            }
        }
        stage ('Test') {
            steps {
               sh 'mvn test'
            }
        }
        stage ('Verify and LoadTest'){
            steps {
               sh 'mvn clean verify'
            }
         }
        stage ('Build') {
            steps {
                sh 'mvn package'
            }
        }
		    // Building Docker images
	    stage('Building image') {
	      steps{
		script {
		  dockerImage = docker.build registry
		}
	      }
	    }

	     // Uploading Docker images into Docker Hub
	    stage('Upload Image') {
	     steps{
		 script {
		    docker.withRegistry( '', registryCredential ) {
		    dockerImage.push()
		    }
		}
	      }
	    }


        stage ('Deploy on Server & Cleanup'){
            steps{
                sh 'ansible-playbook deploy.yml'
                sh "docker rmi ${registry} && mvn clean"
            }
        }

    }
    post {
        always {
          emailext body: '''Good Day Engineer,
          Loki issued a report as follows:

          $PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS.

          Check console output at $BUILD_URL to view the results.''', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', to: 'princekudzainaposa94@gmail.com'
        }

        failure {

           telegramSend(message: "*JOB* : *${env.JOB_NAME}*\n*Report* : ${env.BUILD_TAG} \n*Branch*: main \n*Build* : ${env.BUILD_ID} \n*Status*: _FAILED_ \n*Vist* : ${env.BUILD_URL} for more informantion\n", chatId: 717316992 )
        }
         success {
            telegramSend(message: "*JOB* : *${env.JOB_NAME}*\n*Report* : ${env.BUILD_TAG} \n*Branch*: main \n*Build* : ${env.BUILD_ID} \n*Status*: _SUCCESS_ \n*Vist* : ${env.BUILD_URL} for more informantion\n", chatId: 717316992)

        }
    }
}
