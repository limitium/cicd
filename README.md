Build image locally with docker and push it in local repo
```shell
./gradlew jibDockerBuild
```

Build image in CI and push it into ghcr.io
```shell
./gradlew jib
```

Test image with TestContainers
```shell
./gradlew test
```