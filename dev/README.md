# Citronella Development Tools
This directory contains scripts for installing, running, and stopping
your developer environment for Citronella.

*Note: Citronella is currently in early development. As such, this document
will probably change drastically as development progresses. I will keep this
document updated as the project is developed and refined.*

## Prerequisites
The developer environment uses Docker to run a local version of MariaDB.
You will need to install Docker before proceeding with the rest of the steps
in this document. Visit https://docs.docker.com/get-docker/ to find install
instructions for your platform.

## Initializing the development environment
To initialize your development environment, run `create-dev-env.sh`. This script
will create a directory for storing your development database's data files.
*Note: you only need to do this one time.*

## Starting the database server
To start the database server, run `start-mariadb`.

## Stopping the database server
To stop the database server, run `stop-mariadb`.