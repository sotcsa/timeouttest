all:
	gradlew build
	docker build -t docker-f4-repo.idomsoft.hu/sandboxf4/timeouttest .
	docker push docker-f4-repo.idomsoft.hu/sandboxf4/timeouttest