# Anatomy-Web API Reference

## I. Topics

### 1. GetTopics

URL: `[url]/Topics`

URL example: `localhost:8080/Topics`

Request type: `Get`

Request Body example: `-`

Response example:

    [
        {
            "id": 9,
            "name": null
        },
        {
            "id": 12,
            "name": "topic example"
        }
    ]

### 2. GetTopicById

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Topics/12`

Request type: `Get`

Request Body example:

    -

Response example:

    {
    "id": 12,
    "name": "topic example"
    }

### 3. AddTopic

URL: `[url]/Topics`

URL example: `localhost:8080/Topics`

Request type: `Post`

Request Body example:

    {"name": "topic example"}

Response example:

    {
    "id": 12,
    "name": "topic example"
    }

### 4. UpdateTopic

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Topics/12`

Request type: `Put`

Request Body example:

    {"name": "topic example updated"}

Response example:

    {
    "id": 12,
    "name": "topic example updated"
    }

### 5. DeleteTopic

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Topics/9`

Request type: `Delete`

Request Body example:

    -

Response example:

    -

## II. Systems

### 1. GetSystems

URL: `[url]/Systems`

URL example: `localhost:8080/Systems`

Request type: `Get`

Request Body example: `-`

Response example:

    [
        {
            "id": 8,
            "name": null
        }
    ]

### 2. GetSystemById

URL: `[url]/Systems/{systemId}`

URL example: `localhost:8080/Systems/8`

Request type: `Get`

Request Body example:

    -

Response example:

    {
        "id": 8,
        "name": "system"
    }

### 3. AddSystem

URL: `[url]/System`

URL example: `localhost:8080/Systems`

Request type: `Post`

Request Body example:

    {
    "name": "system example"
    }

Response example:

    {
    "id": 14,
    "name": "system example"
    }

### 4. UpdateSystem

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Systems/8`

Request type: `Put`

Request Body example:

    {
    "name":"updated system"
    }

Response example:

    {
    "id": 8,
    "name": "updated system"
    }

### 5. DeleteSystem

URL: `[url]/Systems/{topicId}`

URL example: `localhost:8080/Systems/13`

Request type: `Delete`

Request Body example:

    -

Response example:

    -
