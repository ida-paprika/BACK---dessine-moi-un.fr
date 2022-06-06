#!/bin/bash

echo '----------'
echo 'Executing script: '$0
echo 'Started at '$(date +"%T.%3N %Z")
echo '----------'

echo 'Connect to postGres...'
psql -h localhost -p 5432 -U postgres -d dessine_moi_un <<MULTILIGNE
\i ddl/schema-reset.ddl.sql
\i ddl/schema.ddl.sql
\i dml/data.dml.sql
\q
MULTILIGNE

echo '----------'
echo 'Ended at '$(date +"%T.%3N %Z")
echo '----------'

exit 0