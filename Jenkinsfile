node("maven") {
  checkout scm
  stage("Checkstyle") {
          echo "Checkstyle"
            sh "mvn checkstyle:checkstyle"
  }
  stage("Test") {
    sh "mvn test"
  }
  stage('Analisis de código') {
          echo "Running Code Analysis"
          sh "mvn sonar:sonar -Dsonar.host.url=https://sonarqube-ci-cd.obe8.bancoppel-dev.openshiftapps.com -Dsonar.projectName=${JOB_BASE_NAME} -Dsonar.login=0bc12facf3109b05790db2f21b3f0d16c8a7d6f1"
   }
  stage("Deploy") {
    sh "mvn fabric8:deploy -Popenshift -DskipTests=true -Dfabric8.namespace=arquetipos-base -Dfabric8.generator.from=registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift"
  }
}