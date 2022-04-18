# Stackdriver Example ✨

## How to run ⚡️
 
1. Install [google cloud sdk](https://cloud.google.com/sdk/docs/install)
2. Authenticate your google cloud installtion by running:
`gcloud auth login`
3. Create a new project and configure gcloud to use it
```
gcloud projects create {PROJECT_ID}
gcloud config set project {PROJECT_ID}
```
4. Create a new pub/sub topic
```
gcloud pubsub topics create test-pub-sub-metric
```
5. Publish some messages by running command many time:
```
gcloud pubsub topics publish test-pub-sub-metrics --message hello
```
6. Generate application defalut credentinal for google client library to connect to your GCP project
```
gcloud auth application-default login
```
7. Run your gradle project 
```
./gradlew run 
```
8. Cleanup: Delete the GCP project that we just created after experimenting! 