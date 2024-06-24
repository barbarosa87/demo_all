pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh "mvn -X clean test"
            }

            post {

                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                        cucumber buildStatus: 'null',
                        customCssFiles: '',
                        customJsFiles: '',
                        failedFeaturesNumber: -1,
                        failedScenariosNumber: -1,
                        failedStepsNumber: -1,
                        fileIncludePattern: '**/*.json',
                        pendingStepsNumber: -1,
                        skippedStepsNumber: -1,
                        sortingMethod: 'ALPHABETICAL',
                        undefinedStepsNumber: -1
                }

                    always {
                        cucumber buildStatus: 'UNSTABLE',
                                failedFeaturesNumber: 1,
                                failedScenariosNumber: 1,
                                skippedStepsNumber: 1,
                                failedStepsNumber: 1,
                                reportTitle: 'My report',
                                fileIncludePattern: '**/*report.json',
                                sortingMethod: 'ALPHABETICAL',
                                trendsLimit: 100
                    }
            }
        }
    }
}