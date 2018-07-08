#create container for /var/jenkins_home
#docker compose to run 2 containers
FROM jenkins/jenkins:latest

USER root
RUN apt-get update \
    && apt-get install -y \
     apt-transport-https \
     ca-certificates \
     curl \
     gnupg2 \
     software-properties-common \
    && curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg \
     | apt-key add - \
    && add-apt-repository \
     "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
     $(lsb_release -cs) \
     stable" \
    && apt-get update \
    && apt-get install -y docker-ce \
    && usermod -aG docker jenkins

USER jenkins
