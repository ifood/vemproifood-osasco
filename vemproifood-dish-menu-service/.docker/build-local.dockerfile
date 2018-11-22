FROM node:latest-alpine
COPY . /opt/dish-menu-service
ENTRYPOINT ["yarn","start"]