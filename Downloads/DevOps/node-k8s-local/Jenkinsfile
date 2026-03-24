pipeline {
    agent any

    stages {

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t node-k8s-local:latest .
                '''
            }
        }

        stage('Start Minikube') {
            steps {
                sh '''
                    minikube start --driver=docker --memory=2048 --cpus=2
                '''
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                # Load latest local docker image into Minikube
                minikube image load node-k8s-local:latest

                # Apply manifests
                minikube kubectl -- apply -f k8s/deployment.yaml
                minikube kubectl -- apply -f k8s/service.yaml
                # Start the Service
                minikube service node-k8s-local-service
                '''
            }
        }
    }
}
