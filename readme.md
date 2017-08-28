## SQL Autocomplete Server

currently it is on development. it gives mock data

### get stared

```bash
sbt docker:publishLocal

docker run -p 8080:8080 sql-autocomoplete-server:0.1-SNAPSHOT #use -d for detached mode 
```

### APIs

1. v1/

2. v1/tables/

3. v1/tables/:tableName
