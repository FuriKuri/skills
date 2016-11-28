# skills
[![Gitter chat](http://img.shields.io/badge/gitter-join%20chat%20%E2%86%92-brightgreen.svg?style=flat-square)](https://gitter.im/skills-app/Lobby)

## Usage

### Build & deploy
```
# Build jar files
$ ./gradlew clean build

# Start docker container
$ docker-compose up -d
```

### REST calls
```
# Create/update an eomplyee
curl -X "PUT" "http://localhost:8082/tpa" \
     -H "Content-Type: application/json" \
     -d "{\"firstName\":\"Theo\",\"lastName\":\"Pack\"}"

# Add skill to an employee
curl -X "PUT" "http://localhost:8082/tpa/skills/Java"

# Request employee
curl -X "GET" "http://localhost:8082/tpa"

# Search for a keyword
curl -X "GET" "http://localhost:8082/search?q=Java"
```
