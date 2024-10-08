#!/bin/bash

HOST="postgres"
USER="postgres"
PASSWORD="postgres"
DATABASE="greenway-db"

psql -h $HOST -U $USER -w -c "CREATE DATABASE $DATABASE;"
psql -h $HOST -U $USER -w -c "GRANT ALL PRIVILEGES ON DATABASE $DATABASE TO $USER;"