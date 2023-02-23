def login() {
    withCredentials([usernamePassword(credentialsId: '8a3bb0ae-9ff1-40e0-a0da-2ef7c1dc2cad', usernameVariable: 'username', passwordVariable: 'password')]) {
        sh """
            docker login --username="${username}" --password="${password}"
        """
    }
}

def build(String tag) {
    sh """
        docker build -t "${tag}" .
    """
}

def push(String tag) {
    sh """
        docker push "${tag}"
    """
}
