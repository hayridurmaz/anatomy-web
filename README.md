# Anatomy-Web API Reference

## Topics

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

### 2. AddTopic

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

### 3. UpdateTopic

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

### 3. DeleteTopic

URL: `[url]/Topics/{topicId}`
URL example: `localhost:8080/Topics/9`
Request type: `Delete`
Request Body example:

    -

Response example:

    -
