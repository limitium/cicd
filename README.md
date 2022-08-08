# jib with github packages and spotless example

## Checkstyle 
```shell
./gradlew build
```
Will run `:spotlessJavaCheck` task to check code for style violations

Code can be reformated according to style rules via
```shell
./gradlew spotlessApply
```
## Build
Build image locally with docker and push it in local repo
```shell
./gradlew jibDockerBuild
```
Now `limitium/cicd-demo` image is available and can be tested via TestContainers

```shell
./gradlew test
```

## Publish
Build image w/o docker demon and push tar to  ghcr.io
```shell
./gradlew jib \
    -Djib.to.image=ghcr.io/limitium/cicd-demo:latest \
    -Djib.to.auth.username=limitium \
    -Djib.to.auth.password={ghp_TOKEN}
```
