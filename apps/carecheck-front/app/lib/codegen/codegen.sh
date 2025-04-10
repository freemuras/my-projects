#! /bin/bash
export $(grep -v '^#' .env | xargs)
SCHEMA_FILE=app/lib/codegen/schema.json
SCHEMA_URL=$NEXT_PUBLIC_SCHEMA_URL

curl $SCHEMA_URL -o $SCHEMA_FILE
orval