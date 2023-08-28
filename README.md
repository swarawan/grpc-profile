# gRPC - Profile

---

This repo will be consumed by [gRPC - Auth](https://github.com/swarawan/grpc-auth). Also has a submodule

Folder structure will be like this
```
- Root
   |__ grpc-protos
        |__ Profile.proto
   |__ src
   |__ build.gradle

```

![Flow app](https://github.com/swarawan/grpc-auth/blob/main/image-1.png?raw=true)


## How to Clone

There are two ways of cloning a repository contains the submodule repository.

### 1. Clone repository recursively
Clone repository with below command to get repository
recursively with the submodules.
```
git clone --recurse-submodules <this-repo-url>
```
So, you will get all the files in this repository, also files in submodule automatically.

### 2. Clone repository separately

With common clone command, you will get only the files inside this repository

#### - Clone this repository
```
git clone <url>
```
See in the `grpc-protos` folder, you will not get submodule files.

#### -. Fetch the submodules
After clone this repository, execute below command to get the submodule files.
```
git submodule init
git submodule update
```

---

## ** WARNING **
If you want to make changes in submodule files, don't change from this repository but
the submodule repository. So you need to clone separately and push. Then update this submodule using
```
git submodule update
```
Voila, submodule has been changed.

## How to Run in Docker

Change to target profile-app host in compose.yml
```
    ...
    ...
    environment:
      - profileHost=host.docker.internal
```

Execute docker compose to build and create a docker container.
```
docker-compose --build -d
```

---

## Related App
- [gRPC - Auth](https://github.com/swarawan/grpc-auth)
- [Protos](https://github.com/swarawan/grpc-protos)