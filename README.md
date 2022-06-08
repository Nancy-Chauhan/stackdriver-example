# Stackdriver Example ✨


## Prerequisites
1. Google cloud account with access to create projects, pub-sub topic and publish messages on those topics.
2. `gcloud` cli tool installed locally as well.
3. Google cloud project with PubSub enabled, just clicking on `pub sub` will enable it for the project. Check [Here](https://console.cloud.google.com/cloudpubsub/topic/list). ![image](https://user-images.githubusercontent.com/17861054/172572677-5b02384e-39c3-4c5d-bfb6-2d819a2fd821.png)


## Run with Gitpod

 Click this button to run your project on [Gitpod](https://gitpod.io/), an open-source developer platform for remote development ☁️ 💻

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://github.com/Nancy-Chauhan/stackdriver-example)


## Setting up google cloud sdk ( on Gitpod )
 
1. Install [google cloud sdk](https://cloud.google.com/sdk/docs/install)
2. Authenticate your google cloud installtion by running: `gcloud auth login`.
**Note :** This will prompt you to run a `gcloud` command locally on your terminal. This is required because `gcloud` requires the oauth validated token to create resources on your behalf. Hence, the requirement to have `gcloud` cli tool installed locally. ![image](https://user-images.githubusercontent.com/17861054/172575293-08390eea-b9ff-462c-a575-a68a3a4b1f2d.png)
3. This is how you'd be prompted on your local machine : ![image](https://user-images.githubusercontent.com/17861054/172575942-79d65def-60c3-4e0f-a7e1-03d027f38fe7.png)
4. It will open a browser window to authenticate with the appropriate google cloud account. On the next step you should see this : ![image](https://user-images.githubusercontent.com/17861054/172576305-84670fab-8702-4a63-bd13-ab093a95daf8.png)
5. Once allowed, the oauth flow would complete and you should see something like this in your terminal window. ![image](https://user-images.githubusercontent.com/17861054/172578034-5326d933-112e-4986-bb3f-971b7e3a193f.png)
6. Copy the output from the terminal, it would be a link starting with `https://localhost:8085/?state=FLqAn...` and paste it in Gitpod terminal. ![image](https://user-images.githubusercontent.com/17861054/172578288-563d415c-b4c9-4fe2-abc0-80cbf47324e5.png)
7. That's it. You're all set to develop remotely on Gitpod 🍊🚀
 

## How to run ⚡️

1. Once you've gcloud setup. Let's continue with the `stackdriver-example` again. 
2. Create a new project and configure gcloud to use it
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
